/**
 * 创建日期 2017-11-3
 */
package com.xx.controller.test;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 功能说明：记录所有rest API的请求日志切面（AOP）
 * 
 * @author 邓锦烨 2017-11-3
 */
@Aspect
@Component
public class RequestLogAspect
{
    private Logger logger = Logger.getLogger(getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    
    @Pointcut("execution(public * com.xx.controller..*.*(..))")
    public void requestLog()
    {
    }

    @Before("requestLog()")
    @Order(5)   /** 设置切面的优先级 */
    public void doBefore(JoinPoint joinPoint) throws Throwable
    {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.debug("URL : " + request.getRequestURL().toString());
        logger.debug("HTTP_METHOD : " + request.getMethod());
        logger.debug("IP : " + request.getRemoteAddr());
        logger.debug("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.debug("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "requestLog()")
    @Order(5)   /** 设置切面的优先级 */
    public void doAfterReturning(Object ret) throws Throwable
    {
        // 处理完请求，返回内容
        logger.debug("RESPONSE : " + ret);
        System.out.println("system current time is " + System.currentTimeMillis());
        System.out.println("startTime is " + startTime);
        System.out.println("get method is " + startTime.get());
//        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
}
