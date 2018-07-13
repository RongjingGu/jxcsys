package com.unimedsci.ydata.jxc.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.*;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.sweetw.idata.commons.exception.CustomException;
import com.unimedsci.ydata.jxc.commons.annotations.Global;
import com.unimedsci.ydata.jxc.commons.annotations.InitClass;
import com.unimedsci.ydata.jxc.commons.util.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MongoDbService extends InitClass {
    static final private Logger _logger = Logger.getLogger(MongoDbService.class
            .getName());

    private MongoClient mongo;

    @Value("${MONGODB_HOST}")
    private String MONGODB_HOST;
    @Value("${MONGODB_PORT}")
    private String MONGODB_PORT;
    @Value("${DBName}")
    private String DBName;

    public void setMongo(MongoClient mongo) {
        this.mongo = mongo;
    }

    public MongoClient getMongo() {
        return mongo;
    }

    /**
     * 初始化mogondb
     */
    public void init() {
        try {
            mongo = new MongoClient(MONGODB_HOST, Integer.valueOf(MONGODB_PORT));
            mongo.getDB(Global.DBName);
        } catch (Exception ex) {
            _logger.log(Level.SEVERE, ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    public DB getDatabase(String databaseName) throws Exception {
        return mongo.getDB(databaseName);
    }

    public DBCollection createCollection(String databaseName,
                                         String collectionName) throws Exception {
        return getDatabase(databaseName).getCollection(collectionName);
    }

    /**
     * 创建索引默认为hash
     */
    public void createIndex(String databaseName,
                            String collectionName, String indexName) throws Exception {
        if (indexName != null && !indexName.isEmpty()) {
            BasicDBObject index = new BasicDBObject();
            index.append(indexName, "hashed");
            getDatabase(databaseName).getCollection(collectionName).createIndex(index);
        }
    }

    public DBCollection getCollection(String databaseName,
                                      String collectionName) throws Exception {
        return getDatabase(databaseName).getCollection(collectionName);
    }

    public boolean isExistUserName(String value, String type) throws Exception {
        DBCollection collection = getCollection(DBName, "user");
        BasicDBObject query = new BasicDBObject();
        if (type.equals("NAME")) {
            query.put("username", value);
        } else if (type.equals("MOBILE")) {
            query.put("userMobile", value);
        }
        DBObject object = collection.findOne(query);
        return object != null;
    }

    public void createUser(String username, String password, String userMobile) throws Exception {

        BasicDBObject object = new BasicDBObject();
        object.put("username", username);
        object.put("password", StringUtil.Encrypt(password));
        object.put("userMobile", userMobile);
        DBCollection collection = getCollection(DBName, "user");
        collection.insert(object);
    }

    public JSONObject queryUsers(Integer offset, Integer limit, String username) throws Exception {
        JSONObject object = new JSONObject();
        DBCollection collection = getCollection(DBName, "user");
        BasicDBObject query = new BasicDBObject();
        if (username != null) {
            query.put("username", StringUtil.getLike(username));
        }
        Cursor cursor = collection.find(query).skip((offset - 1) * limit).limit(limit);
        int totalCount = collection.find(query).count();
        object.put("totalCount", totalCount);

        List<Object> objectList = new ArrayList<Object>();
        while (cursor.hasNext()) {
            BasicDBObject document = (BasicDBObject) cursor.next();
            JSONObject object1 = JSON.parseObject(document.toString());
            objectList.add(object1);
        }
        object.put("datas", objectList);
        return object;
    }

    public void login(String username, String password,JSONObject result) throws Exception {
        DBCollection collection = getCollection(DBName, "user");
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);
        DBObject object = collection.findOne(query);
        if (object != null) {
            String _password = object.get("password").toString();
            if (!_password.equals(StringUtil.Encrypt(password))) {
                throw new CustomException("用户名或密码错误");
            } else {
                result.put("data", JSON.parseObject(object.toString()));
            }
        } else {
            throw new CustomException("用户名或密码错误");
        }
    }


    public void saveFile(String collectionName, String fileid, String companyid, String filename) {
        try {
            File file = new File("D:/feif.jpg");
            DB db = getDatabase(DBName);
            // 存储fs的根节点
            GridFS gridFS = new GridFS(db, collectionName);
            GridFSInputFile gfs = gridFS.createFile(file);
            gfs.put("aliases", companyid);
            gfs.put("filename", file.getName());
            gfs.put("contentType", "jpg");
            gfs.save();
            String a = gfs.getId().toString();
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("存储文件时发生错误！！！");
        }
    }

    public void downloadFile(HttpServletRequest req, HttpServletResponse res) {
        try {
            String appDir = req.getParameter("appDir");
            String filename = req.getParameter("filename");
            System.out.println("打印参数：appDir=" + appDir + ",filename=" + filename);
            DB db = getDatabase(DBName);
            GridFS gridFS = new GridFS(db, "file");

            BasicDBObject query = new BasicDBObject();
            GridFSDBFile gridFSDBFile =  gridFS.findOne(filename);

            if (gridFSDBFile != null) {
                OutputStream sos = res.getOutputStream();
                res.setCharacterEncoding("UTF-8");
                res.setHeader("Access-Control-Allow-Origin", "*");
                res.setContentType("application/octet-stream");
                res.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                gridFSDBFile.writeTo(sos);
                sos.flush();
                sos.close();
            }
        } catch (Exception e) {
            System.out.println("下载文件异常 ...");
            e.printStackTrace();
        }
    }


}
