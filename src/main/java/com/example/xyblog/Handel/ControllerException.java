package com.example.xyblog.Handel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

// 拦截错误信息，跳转到错误页面
@ControllerAdvice
public class ControllerException {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 拦截所有异常信息
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandel(HttpServletRequest request, Exception e) throws Exception {
        //错误信息打印成日志
        logger.error("Request URL: {} Exception : {}",request.getRequestURL(),e);

        //当标识了状态码的时候就不拦截,抛出交给虚拟机处理如：404,500等
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null){
            throw e;
        }

        //定义返回的视图
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;
    }

}
