package com.yy.common.entity.ms.notice;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yy.common.entity.base.BaseMsEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@TableName("sys_staff")
@ApiModel(value = "SysStaff对象", description = "")
public class SysStaff extends BaseMs implements Serializable {

private static final long serialVersionUID = 1L;

/**
* id
*/
@ApiModelProperty("id")
private Short id;

/**
* 账号工号
*/
@ApiModelProperty("账号工号")
private String code;

/**
* 账号密码
*/
@ApiModelProperty("账号密码")
private String password;

/**
* 账号姓名
*/
@ApiModelProperty("账号姓名")
private String name;

/**
* 逻辑状态
*/
@ApiModelProperty("账号姓名")
private String state;

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
}
