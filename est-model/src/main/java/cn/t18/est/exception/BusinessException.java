package cn.t18.est.exception;


import lombok.Data;

/**
 * 业务异常类
 */
@Data
public class BusinessException extends Exception{

    private String code;

    public BusinessException(){
    }
    public BusinessException(String code, String msg){
        super(msg);
       this.code=code;
    }

}
