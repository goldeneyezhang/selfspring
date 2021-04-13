package com.example.demo.mylog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author yibozhang@ctrip.com
 * @create: 2021-04-12 11:29
 * @description
 **/
@Aspect
@Component
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     *   两个..代表所有子目录，最后括号里的两个..代表所有参数
     */

    @Pointcut("execution(public * com.example.demo.controller.IndexController.*(..))")
    public void logPointCut(){

    }
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        // 接受到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("请求地址：" + request.getRequestURI());
        logger.info("HTTP METHOD : " + request.getMethod());
        //获取真实的ip
        logger.info("CLASS_METHOD："+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("参数 :" + Arrays.toString(joinPoint.getArgs()));
    }
    @After("logPointCut()")
    public void doAfterReturning(JoinPoint joinPoint) throws Throwable{
        logger.info("after signature+ :" + joinPoint.getSignature());
    }
    //在事件通知类型中申明returning即可获取返回值
    @AfterReturning(value = "logPointCut()", returning="returnValue")
    public void logMethodCall(JoinPoint jp, Object returnValue) throws Throwable {
        System.out.println("进入后置增强了！");
        String name = jp.getSignature().getName();
        System.out.println(name);
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("参数：" + arg);
        }
        System.out.println("方法返回值为：" + returnValue);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
        logger.info("around耗时:" + (System.currentTimeMillis()- startTime));
        return ob;
    }
}
