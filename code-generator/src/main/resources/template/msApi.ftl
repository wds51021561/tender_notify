package com.yy.ms.dao.notice.api;

import com.yy.common.inter.api.ms.notice.SysStaffApi;
import com.yy.ms.dao.notice.mapper.SysStaffMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/ms/notice/sysStaff")
public class SysStaffApiImpl implements SysStaffApi {

@Resource
private SysStaffMapper sysStaffMapper;

}
