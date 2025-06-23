package com.yy.common.entity.ms.notice;

import com.yy.common.entity.base.BaseMsEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yyunyy
 * @since 2025-06-18
 */
@Getter
@Setter
@ApiModel(value = "SysStaff对象", description = "")
public class SysStaff extends BaseMsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

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

}
