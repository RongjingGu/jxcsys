package com.unimedsci.ydata.jxc.commons.service;

import com.unimedsci.ydata.jxc.commons.dao.WxMapper;
import com.unimedsci.ydata.jxc.commons.datas.WxBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WxService {
    @Autowired
    WxMapper wxMapper;

    public void update(WxBase wxBase){
        wxMapper.update(wxBase);
    }

    public void insert(WxBase wxBase){
        wxMapper.insert(wxBase);
    }

    public WxBase selectByOpenid(String openId){
        return wxMapper.selectByOpenid(openId);
    }


}
