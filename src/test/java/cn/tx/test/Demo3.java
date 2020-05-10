package cn.tx.test;

import cn.tx.demo2.UserService;
import cn.tx.demo3.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_demo3.xml")
public class Demo3 {

    @Autowired
    private OrderService orderService;

    /**
     * 测试
     */
    @Test
    public void run1(){
        orderService.save();
    }

}
