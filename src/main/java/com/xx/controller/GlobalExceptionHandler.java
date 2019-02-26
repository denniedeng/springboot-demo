/**
 * 创建日期 2017-11-2
 */
package com.xx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.entity.ErrorInfo;
import com.xx.service.SuperException;

/**
 * 功能说明：统一处理错误返回信息
 * @author 邓锦烨 2017-11-2
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(value = SuperException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, SuperException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData(e.getMessage());
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
