package com.unimedsci.ydata.jxc.commons.util;

import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.sweetw.idata.commons.DataResult;

import java.util.List;

public class Page {

    public static DataResult createDataResult(PageList pageList) {
        DataResult dr = new DataResult();
        dr.setCount(pageList.size());
        dr.setTotalCount(pageList.getPaginator().getTotalCount());
        dr.setDatas(pageList);
        return dr;
    }

    public static DataResult createDataResultList(List strs) {
        DataResult dr = new DataResult();
        dr.setCount(strs.size());
        dr.setTotalCount(strs.size());
        dr.setDatas(strs);
        return dr;
    }


    public static JSONObject createJsonObjectResult(List datas) {
        JSONObject jsonObject = new JSONObject();
        if (datas != null && datas.size() > 0) {
            jsonObject.put("data", datas);
            jsonObject.put("totalCount", datas.size());
        } else {
            jsonObject.put("data", datas);
            jsonObject.put("totalCount", 0);
        }
        return jsonObject;
    }


}
