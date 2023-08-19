package com.example.waimaiorder.common.response;

import com.example.waimaiorder.common.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    /**
     * 操作成功
     */
    public static final int SUCCESS = 200;
    /**
     * 响应业务状态码
     */
    private Integer status;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应中的数据
     */
    private Object data;

    /**
     *
     * @param data 需要返回的数据
     */
    public Result(Object data){
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Result(){
        this.status = 200;
        this.msg = "OK";
        this.data = "";
    }

    /**
     *
     * @param errorCodeEnum 异常枚举类对象
     * @return
     */
    public static Result error(ErrorCodeEnum errorCodeEnum){
        return new Result(errorCodeEnum.getCode(),errorCodeEnum.getMsg(),"");
    }
}
