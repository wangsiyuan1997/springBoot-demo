package com.springboot5.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * 处理整个 MVC 的异常类
 * @Date And @Time: 2022/1/11  21:30
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NullPointerException.class,ArithmeticException.class, MissingServletRequestParameterException.class}) //异常处理
    public String handlerArithException(Exception e){

        log.info("处理的异常有：{}",e);
        return "login";
    }
}
