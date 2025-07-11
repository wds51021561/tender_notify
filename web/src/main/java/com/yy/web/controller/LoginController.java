package com.yy.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yy.common.entity.base.CommonReq;
import com.yy.common.entity.base.CommonResp;
import com.yy.common.entity.ms.notice.SysStaff;
import com.yy.common.inter.api.ms.notice.SysStaffApi;
import com.yy.common.inter.sys.ICache;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {


    private final ICache iCache;

    private final SysStaffApi sysStaffApi;


    @RequestMapping("staffInfo")
    public CommonResp<List<SysStaff>> staffInfo(@RequestBody CommonReq<String> req) {
        SysStaff sysStaff = new SysStaff();
        sysStaff.setCode(req.getData());
        LambdaQueryWrapper<SysStaff> wrapper = new LambdaQueryWrapper<>(sysStaff);
        List<SysStaff> byCodeList = sysStaffApi.getByCodeList(wrapper);
        return CommonResp.success(byCodeList);
    }

    @RequestMapping("initStaff")
    public CommonResp<SysStaff> initStaff(@RequestParam("code") String code) {
        SysStaff sysStaff = new SysStaff();
        sysStaff.setCode("123");
        sysStaff.setId(1L);
        sysStaff.setName("cc");
        sysStaff.setState("E");
        sysStaff.init();
        sysStaffApi.insert(sysStaff);
        return CommonResp.success(sysStaff);
    }

}
