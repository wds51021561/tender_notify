package com.yy.common.entity.base;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommonReq<T> extends BaseReq {

    private T data;

}
