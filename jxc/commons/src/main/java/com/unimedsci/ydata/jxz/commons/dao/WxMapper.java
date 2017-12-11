package com.unimedsci.ydata.jxz.commons.dao;

import com.unimedsci.ydata.jxz.commons.datas.WxBase;
import org.springframework.stereotype.Repository;

@Repository
public interface WxMapper {
    int deleteByPrimaryKey(String openId);

    int insert(WxBase record);

    int insertSelective(WxBase record);

    WxBase selectByOpenid(String openid);

    int updateByPrimaryKeySelective(WxBase record);

    int update(WxBase record);
}