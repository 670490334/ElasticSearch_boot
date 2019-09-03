package chshady.joy.demo.configbean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author 廖凡
 * @Date 2019/8/20 17:27
 */
@Data
public class Result {
    private boolean success;
    private String message;
    private Integer code;
    private Object data;
    public Result(){

    }
    public static Result ok(Object data){
        Result result = new Result();
        result.setCode(Status.SUCCESS.getCode());
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public Result(int code,String message){
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public static Result ofMessage(int code,String message){
        return new Result(code,message);
    }
    public static Result notLogin(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(Status.NOT_LOGIN.getCode());
        result.setMessage(Status.NOT_LOGIN.getStandardMessage());
        return result;
    }
    /**
     * 枚举
     */
    public enum Status {
        SUCCESS(200,"OK"),
        BAD_REQUEST(400,"Bad Request"),
        INTERNAL_SERVER_ERROR(500,"UnKonwn Internal"),
        NOT_SUPPORTED_OPERATON(40005,"Operation not supported"),
        NOT_LOGIN(50000,"Not Login");


        @Getter
        @Setter
        private int code;
        @Setter
        @Getter
        private String standardMessage;
        Status(int code,String standardMessage){
            this.code = code;
            this.standardMessage = standardMessage;
        }
    }
}
