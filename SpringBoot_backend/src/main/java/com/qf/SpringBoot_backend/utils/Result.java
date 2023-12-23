package com.qf.SpringBoot_backend.utils;

import com.qf.SpringBoot_backend.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Result 后端返回前端的结果模板")
public class Result<T> {
    private String code;//状态码
    private String msg;//消息
    private T data;//未知类型，具体传入的类型来决定

    public Result(){};
    public Result(T data){this.data=data;};

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

    //success 请求成功
    public static Result success(){
        Result result =new Result();
        result.setCode("0");
        result.setMsg("请求成功");
        return result;
    }

    //success 请求成功，向前端返回数据
    public static<T> Result success(T data){
        Result result =new Result<>(data);
        result.setCode("0");
        result.setMsg("请求成功");
        return result;
    }

    //error请求失败
    public static Result error(String code,String msg){
        Result result =new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
