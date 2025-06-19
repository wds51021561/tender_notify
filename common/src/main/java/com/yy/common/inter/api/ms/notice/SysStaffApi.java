package com.yy.common.inter.api.ms.notice;

import com.yy.common.entity.ms.notice.SysStaff;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "${feign.ms.url:localhost:55555}" ,name = "msApi",path = "/ms/notice/sysStaff")
//@Primary
public interface SysStaffApi {

    @PostMapping("/getByCode")
    SysStaff getByCode(@RequestBody SysStaff code);

    @PostMapping("/getByCodeList")
    List<SysStaff> getByCodeList(@RequestBody SysStaff code);

    @PostMapping("/insert")
    int insert(@RequestBody SysStaff sysStaff);

}
