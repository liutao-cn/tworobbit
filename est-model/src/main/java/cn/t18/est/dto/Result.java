package cn.t18.est.dto;

/**
 * 传输数据类
 */
public class Result<T>{
    private String code;   //响应给前台的编码
    private String msg;  //响应给前台的信息
    private T data;      //响应的数据

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    //调用该方法响应给前端数据
   public static <T>Result success(String code, String msg, T data){
       Result result = new Result(code,msg,data);
        return result;
   }

    public static <T> Result success(String code, String msg){
        return success(code,msg,null);
    }

    public static <T> Result success(T data){
        return success("200","success",data);
    }
    public static <T> Result success(){
        return success("200","success",null);
    }


    //调用该方法响应错误信息给前端
    public static <T> Result error(String code, String msg){
        Result result = new Result(code,msg,null);
        return result;
    }


}
