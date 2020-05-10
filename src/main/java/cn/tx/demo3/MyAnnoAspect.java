package cn.tx.demo3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 * 切面类
 */
@Component  // 把该类交给IOC去管理
@Aspect     // 声明是切面类  == <aop:aspect ref="myXmlAspect">
public class MyAnnoAspect {

    /**
     * 通知的方法
     */
    // @Before(value = "切入点的表达式")
    // @Before(value = "execution(public * cn.tx.demo3.OrderServiceImpl.save(..))")     前置通知
    // @After(value = "execution(public * cn.tx.demo3.OrderServiceImpl.save(..))")     // 最终通知
    // @AfterReturning     // 后置通知
    // @AfterThrowing      // 异常通知

    // 环绕通知，目标对象方法需要手动执行
    @Around(value = "execution(public * cn.tx.demo3.OrderServiceImpl.save(..))")
    public void log(ProceedingJoinPoint point){
        try {
            System.out.println("增强了...");
            point.proceed();
            System.out.println("增强了...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
