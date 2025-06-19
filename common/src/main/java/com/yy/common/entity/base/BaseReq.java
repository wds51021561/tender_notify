package com.yy.common.entity.base;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BaseReq {

    protected String token;

    protected String reqUuid;

    protected Date reqTime;

}
