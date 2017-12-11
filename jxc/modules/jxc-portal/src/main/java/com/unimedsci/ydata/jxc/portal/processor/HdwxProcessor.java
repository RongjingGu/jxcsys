package com.unimedsci.ydata.jxc.portal.processor;

import com.sweetw.idata.wx.data.*;
import com.sweetw.idata.wx.global.WXGlobal;
import com.sweetw.idata.wx.process.Processor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 2017/11/21.
 */
@Component
public class HdwxProcessor implements Processor {
    public WxPushMessageMediaResponse process(WxPushMessage pushMessage,
                                              WxUser user,
                                              String sceneId,
                                              String ticket,
                                              HttpServletRequest request,
                                              HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        //WxPushMessageMediaResponse mediaResponse = new WxPushMessageMediaResponse();
        //判断当前用户是否绑定

        //if 绑定 根据用户当前角色 返回不同的页面
        //if(doctor) {
        // return
		/* 	//微.数据
		 *  //添加病例
		 *  //查看病例
		 */
        //}

        /**
         * else if(patient){
         * 	//微.数据
         *  //添加就诊
         *  //查看数据
         * }
         */


        String openId = user.getOpenid();

        return createBindingResponse(user,pushMessage);
    }

    /**
     * 返回绑定推送页面
     * @return
     */
    private WxPushMessageMediaResponse createBindingResponse(WxUser user,WxPushMessage pushMessage){

        WxPushMessageMediaResponse response =  WxPushMessageMediaResponse.createInstanceFromPushMessage(pushMessage);
        ArticlesList al = new ArticlesList();
        WxArticleItem item1 =new WxArticleItem();
        String  baseUrl = WXGlobal.GLOBAL_URL;
        item1.setPicUrl(baseUrl+"/images/bindingPush.jpg");
        item1.setDescription("享受服务请先绑定帐号");
        item1.setTitle("绑定");
        item1.setUrl(baseUrl+"/binding.do?openId="+user.getOpenid());
        List<WxArticleItem> items = new ArrayList<WxArticleItem>();
        items.add(item1);
        al.setItem(items);
        response.setArticles(al);
        return response;
    }
}
