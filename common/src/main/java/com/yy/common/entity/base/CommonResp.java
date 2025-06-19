package com.yy.common.entity.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResp<T> extends BaseResp {
    private T data;

    public CommonResp<T>  success(String message,T data){
        this.code = "SUCCESS";
        this.message = message;
        this.data = data;
        return this;
    }

    public CommonResp<T>  fail(String code ,String message){
        this.code = code;
        this.message = message;
        return this;
    }

    public CommonResp<T>  success(T data){
        return success("操作成功",data);
    }

    public CommonResp<T>  success(String message){
        return success(message,null);
    }


}
