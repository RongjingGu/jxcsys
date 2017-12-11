package com.unimedsci.ydata.jxc.portal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by casteloyee on 2017/6/10. ydata.org
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@WebAppConfiguration
@ContextConfiguration("classpath*:/applicationContext.xml")
@ActiveProfiles("test")
public class BaseUnitTest {

    @Test
    public void baseTest() {

    }
}
