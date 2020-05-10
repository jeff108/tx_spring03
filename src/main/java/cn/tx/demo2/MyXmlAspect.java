package cn.tx.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 *
 * 自定义切面类 = 切入点(表达式) + 通知(增强的代码)
 */
public class MyXmlAspect {

    /**
     * 通知
     */
    public void log(){
        // 发送手机短信
        // 发送邮件/记录日志/事务管理
        System.out.println("增强的方法执行了...");
    }

    /**
     * 环绕通知
     * 问题：目标对象的方法没有执行，需要手动执行目标对象的方法。
     */
    public void aroundLog(ProceedingJoinPoint point){
        try {
            System.out.println("增强的方法执行了...前");
            // 让目标对象的方法去执行
            point.proceed();
            System.out.println("增强的方法执行了...后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            System.out.println("xxxxx");
        }
    }

}
