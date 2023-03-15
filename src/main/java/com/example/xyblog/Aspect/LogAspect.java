package com.example.xyblog.Aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    // 获取日志类对象
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 定义切面
    @Pointcut("execution(* com.example.xyblog.Controller.*.*(..))")
    public void log() {
    }

    // 前置方法
    @Before("log()")
    public void doBefore(JoinPoint jp) {
        // 通过获取request上下文获取request对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取ip, 请求url, 类名和方法名, 方法参数
        String ip = request.getRemoteAddr();
        String url = request.getRequestURI();
        String method = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        Object[] args = jp.getArgs();

        // 封装日志实体
        RequestLog log = new RequestLog(ip, url, method, args);
        logger.info("Request: {}", log);
    }

    @After("log()")
    public void doAfter(){}

    // 后置结果增强
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result :{}", result);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class RequestLog {
        private String ip;
        private String url;
        private String method;
        private Object[] args;

        @Override
        public String toString() {
            return "RequestLog{" +
                    "ip=’" + ip + '\'' +
                    ",url='" + url + '\'' +
                    ",method='" + method + '\'' +
                    ",args=" + Arrays.toString(args) +
                    '}';
        }
    }

}
