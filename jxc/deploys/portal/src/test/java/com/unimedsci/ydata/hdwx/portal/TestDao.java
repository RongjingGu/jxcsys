package com.unimedsci.ydata.hdwx.portal;

import com.unimedsci.ydata.jxz.commons.dao.CrfAuthMapper;
import com.unimedsci.ydata.jxz.commons.datas.CrfAuth;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Gurongjing on 2017/6/19.
 * Hfkj
 */
public class TestDao extends BaseUnitTest {
    @Autowired
    CrfAuthMapper crfAuthMapper;

    @Test
    public void Int() {
        CrfAuth crfAuth = new CrfAuth();
        crfAuth.setAuth("C//");
        crfAuth.setVisitTypeId(1);
        crfAuth.setModuleId(1);
        crfAuthMapper.insert(crfAuth);

    }

    @Test
    public void select() {
        CrfAuth crfAuth = crfAuthMapper.selectByPrimaryKey(1);
        System.out.println(crfAuth.getAuth());
    }

    @Test
    public void update() {
        CrfAuth crfAuth = crfAuthMapper.selectByPrimaryKey(1);
        crfAuth.setAuth("good morning");
        crfAuthMapper.updateByPrimaryKey(crfAuth);
        System.out.println(crfAuth.getAuth());
    }

    @Test
    public void delelte() {
        crfAuthMapper.deleteByPrimaryKey(1);
    }


}
