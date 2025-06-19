package com.yy.common.entity.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public abstract class BaseMsEntity {

    /**
     * 逻辑状态
     */
    @ApiModelProperty("账号姓名")
    private String state = "E";

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime ctDate;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime upDate;

    public void init(){
        this.ctDate = LocalDateTime.now();
        this.upDate = LocalDateTime.now();
        this.state = "E";
    }
}
