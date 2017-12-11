package com.unimedsci.ydata.jxc.main.manager;

import com.sweetw.idata.commons.exception.CustomException;
import com.unimedsci.ydata.jxc.commons.dao.EditorImgDetailMapper;
import com.unimedsci.ydata.jxc.commons.dao.EditorImgMapper;
import com.unimedsci.ydata.jxc.commons.datas.EditorImg;
import com.unimedsci.ydata.jxc.commons.datas.EditorImgDetail;
import com.unimedsci.ydata.jxc.main.data.FileMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Alan on 2017/12/5.
 */
@Component
public class ImageManager {
    @Autowired
    EditorImgMapper editorImgMapper;

    @Autowired
    EditorImgDetailMapper editorImgDetailMapper;

    private static final Logger _logger = Logger.getLogger(ImageManager.class.getName());

    @Transactional
    public List<String> uploadEditorImg(MultipartHttpServletRequest request){
        List<String> retUrlList = new ArrayList<String>();
        //0.
        HttpSession session = request.getSession();
        Object tmp = session.getAttribute("editorImgId");
        Integer editorImgId = null;
        if(tmp == null){
            //0.1
            EditorImg editorImg = new EditorImg();
            editorImg.setLastViewTime(new Date());
            editorImgMapper.insert(editorImg);
            editorImgId = editorImg.getEditorImgId();
            session.setAttribute("editorImgId",editorImgId);
        }
        else{
            //0.2
            editorImgId = Integer.valueOf(tmp.toString());
        }

        //1. build an iterator
        Iterator<String> itr =  request.getFileNames();

        //2. get each file
        MultipartFile mpf = null;
        while(itr.hasNext()){
            //2.1 get next MultipartFile
            mpf = request.getFile(itr.next());
            String url = request.getServletPath();

            String imgUuid = generateImgUuid("editorImg",mpf);

            EditorImgDetail detail = new EditorImgDetail();
            detail.setEditorImgId(editorImgId);
            detail.setImgUuid(imgUuid);
            editorImgDetailMapper.insert(detail);

            retUrlList.add(imgUuid);
        }
        return retUrlList;
    }

    @Transactional
    public void fillEditorImg(String imgUuid, HttpServletResponse response){
        imgUuid = editorImgDetailMapper.selectUuidByUuid(imgUuid);

        if(imgUuid == null || "".equals(imgUuid)) return;

        fillImgByUuid(imgUuid,"editorImg",response);
    }

    public void fillImg(String imgUuid, HttpServletResponse response){

        fillImgByUuid(imgUuid,"img",response);
    }


    private void fillImgByUuid(String imgUuid,String folder,HttpServletResponse response){
        String path = this.getClass().getClassLoader().getResource("").getPath().replace("/",File.separator);

        path += File.separator + folder + File.separator;

        try{
            FileInputStream file = new FileInputStream(path + imgUuid);

            FileCopyUtils.copy(file, response.getOutputStream());
        }
        catch (Exception ex){
            throw new CustomException("获取图片失败");
        }

    }

    private String checkImage(String contentType){
        String[] types = contentType.split("/");


        if(types == null || types.length < 2){
            throw new CustomException("非图片文件");
        }

        if(!"image".equals(types[0])){
            throw new CustomException("非图片文件");
        }

        return types[1];
    }

    private String generateImgUuid(String folder,MultipartFile mpf){
        String suffix = checkImage(mpf.getContentType()) ;

        String path = this.getClass().getClassLoader().getResource("").getPath().replace("/",File.separator);

        String uri = this.getClass().getResource("").getPath();
        path += File.separator + folder + File.separator;

        String uuid = UUID.randomUUID().toString().replace("-","");

        String fileName = uuid + "." + suffix;

        try{
            File dir = new File(path);
            if(!dir.exists()) {
                if( !dir.mkdir()){

                    throw new CustomException("创建文件目录失败");
                }
            }
            FileOutputStream out =   new FileOutputStream(path + fileName);
            FileCopyUtils.copy(mpf.getBytes(),out);
            out.flush();
        }
        catch (Exception ex){
            throw new CustomException("上传图片失败");
        }

        return fileName;
    }

    public List<FileMeta> uploadImg(MultipartHttpServletRequest request){
        LinkedList<FileMeta> files = new LinkedList<FileMeta>();

        //1. build an iterator
        Iterator<String> itr =  request.getFileNames();

        //2. get each file
        MultipartFile mpf = null;
        while(itr.hasNext()){
            //2.1 get next MultipartFile
            mpf = request.getFile(itr.next());

            String imgUuid = generateImgUuid("img",mpf);

            FileMeta fileMeta = new FileMeta();
            fileMeta.setFileName(imgUuid);
            fileMeta.setFileType(mpf.getContentType());

            String url = request.getServerName() + ":" + request.getServerPort() + "/"
                    + request.getContextPath() + "/multimedia/img/get.do?value=" + imgUuid;
            fileMeta.setUrl(url);
            files.add(fileMeta);


        }
        return files;
    }

    public String generateUrlByImgUuid(String imgUuid,HttpServletRequest request){
        String url = request.getServerName() + ":" + request.getServerPort() + "/"
                + request.getContextPath() + "/multimedia/img/get.do?value=" + imgUuid;

        return url;
    }
}
