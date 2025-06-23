package com.yy.common.entity.base;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public abstract class BaseReq {

    protected String token;

    protected String reqUuid;

    protected LocalDateTime reqTime;

}
