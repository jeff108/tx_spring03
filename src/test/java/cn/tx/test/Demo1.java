package cn.tx.test;

import cn.tx.demo1.Account;
import cn.tx.demo1.AccountService;
import cn.tx.demo1.JdkProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class Demo1 {

    @Test
    public void run1() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_demo1.xml");
        // 获取service对象
        AccountService accountService = (AccountService) ac.getBean("accountService");

        Account account1 = new Account();
        account1.setName("熊大");
        account1.setMoney(1000d);

        Account account2 = new Account();
        account2.setName("美羊羊");
        account2.setMoney(1000d);

        // 生成代理对象
        Object proxyobj = JdkProxy.getProxy(accountService);
        // 强转
        AccountService proxy = (AccountService) proxyobj;

        // 调用代理对象方法
        proxy.saveAll(account1,account2);
    }

}
