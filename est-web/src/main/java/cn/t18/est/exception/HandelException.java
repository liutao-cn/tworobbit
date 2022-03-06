package cn.t18.est.exception;

import cn.t18.est.dto.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 异常处理类
 */
@RestControllerAdvice   //控制层增强
public class HandelException {

    //处理系统异常
    @ExceptionHandler(Exception.class)
    public Result HandelException(Exception e){
        return Result.error("5","系统异常");
    }

    //处理业务异常
    @ExceptionHandler(BusinessException.class)
    public Result HandelServiceException(BusinessException s){
        return Result.error(s.getCode(),s.getMessage());
    }


}
