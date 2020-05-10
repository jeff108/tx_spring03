package cn.tx.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 *
 * 传入目标对象，生成该对象的代理对象，返回。对目标对象的方法进行增强
 */
public class JdkProxy {

    /**
     * 获取代理对象，返回，增强目标对象的方法
     * @param accountService
     * @return
     */
    public static Object getProxy(AccountService accountService){

        /**
         * 使用Jdk的动态代理生成代理对象
         */
        Object proxy = Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * 调用代理对象的方法，invoke方法就会去执行
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    // 开启事务
                    TxUtils.startTransaction();

                    // 对象目标对象的方法进行增强
                    result = method.invoke(accountService, args);

                    // 提交事务
                    TxUtils.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    TxUtils.rollback();
                } finally {
                    // 关闭资源
                    TxUtils.close();
                }
                return result;
            }
        });
        return proxy;
    }

}
