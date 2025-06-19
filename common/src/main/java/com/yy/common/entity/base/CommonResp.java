package com.yy.common.entity.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResp<T> extends BaseResp {
    private T data;

    public static <T> CommonResp<T>  success(String message,T data){
        CommonResp<T> resp = new CommonResp<>();
        resp.code = "SUCCESS";
        resp.message = message;
        resp.data = data;
        return resp;
    }

    public static <T> CommonResp<T>  fail(String code ,String message){
        CommonResp<T> resp = new CommonResp<>();
        resp.code = code;
        resp.message = message;
        return resp;
    }

    public static <T> CommonResp<T>  success(T data){
        return success("操作成功",data);
    }

    public static <T> CommonResp<T>  success(String message){
        return success(message,null);
    }


}
