package com.yy.common.inter.api.ms.notice;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yy.common.entity.ms.notice.SysStaff;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "${feign.ms.url:localhost:55555}" ,primary = false, name = "msApi",path = "/ms/notice/sysStaff")
public interface SysStaffApi {

    @PostMapping("/getByCode")
    SysStaff getByCode(@RequestBody SysStaff code);

    @PostMapping("/getByCodeList")
    List<SysStaff> getByCodeList(@RequestBody LambdaQueryWrapper<SysStaff> wrapper);

    @PostMapping("/insert")
    int insert(@RequestBody SysStaff sysStaff);

}
