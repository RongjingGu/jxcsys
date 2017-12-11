package com.unimedsci.ydata.jxc.commons.service;

import com.unimedsci.ydata.jxc.commons.dao.YdataAccountBindMapper;
import com.unimedsci.ydata.jxc.commons.datas.YdataAccountBind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan on 2017/12/6.
 */
@Service
public class YDataAccountBindService {
    @Autowired
    YdataAccountBindMapper ydataAccountBindMapper;

    public List<YdataAccountBind> queryActiveBingByOpenid(String openid){
        return ydataAccountBindMapper.selectByOpenidAndStatus(openid, YdataAccountBind.Status.ACTIVE);
    }

    public int unbindByOpenidList(List<String> openidList){
        return ydataAccountBindMapper.unbindByOpenidList(openidList);
    }

    public int unbindByOpenid(String openid){
        return ydataAccountBindMapper.unbindByOpenid(openid);
    }
}
