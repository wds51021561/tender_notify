package com.yy.common.entity.req;

import com.yy.common.entity.base.BaseReq;
import com.yy.common.util.UuidUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WebReq extends BaseReq {
    public WebReq(){
        this.reqUuid = UuidUtil.getUuid();
        this.reqTime = new Date();
    }
}
