package com.unimedsci.ydata.jxc.main.controller;

import com.alibaba.fastjson.JSONObject;
import com.sweetw.idata.commons.exception.CustomException;
import com.unimedsci.ydata.jxc.main.data.FileMeta;
import com.unimedsci.ydata.jxc.main.manager.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Alan on 2017/12/4.
 */
@Controller("multimediaController")
@RequestMapping("multimedia")
public class MultimediaController {

    @Autowired
    ImageManager imageManager;

    /**
     * 支持多图上传
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "uploadEditorImg", method = RequestMethod.POST)
    public JSONObject uploadEditorImg(
            MultipartHttpServletRequest request,
            HttpServletResponse response)
    {
        try{
            JSONObject ret = new JSONObject();
            List<String> imgNameList = imageManager.uploadEditorImg(request);

            ret.put("errno","0");
            ret.put("data",imgNameList);

            return ret;
        }
        catch (Exception ex){
            throw new CustomException("图片上传失败");
        }
    }

    @RequestMapping(value = "/editor/img/get", method = RequestMethod.GET)
    @Transactional
    public void editorImgGet(
            HttpServletResponse response,
            @RequestParam String value){
        try {
            imageManager.fillEditorImg(value,response);

        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/img/get", method = RequestMethod.GET)
    @Transactional
    public void imgGet(HttpServletResponse response,
                       @RequestParam("value") String value){
        try {
            imageManager.fillImg(value,response);

        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "uploadImg", method = RequestMethod.POST)
    public JSONObject uploadImg( MultipartHttpServletRequest request,
    HttpServletResponse response)
    {
        try{
            JSONObject ret = new JSONObject();
            List<FileMeta> imgList = imageManager.uploadImg(request);

            ret.put("errno","0");
            ret.put("data",imgList);

            return ret;
        }
        catch (Exception ex){
            throw new CustomException("图片上传失败");
        }
    }
}
