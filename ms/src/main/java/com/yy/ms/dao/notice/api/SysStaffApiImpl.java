package com.yy.ms.dao.notice.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yy.common.entity.ms.notice.SysStaff;
import com.yy.common.inter.api.ms.notice.SysStaffApi;
import com.yy.ms.dao.notice.mapper.SysStaffMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yyunyy
 * @since 2025-06-18
 */
@RestController
@RequestMapping("/ms/notice/sysStaff")
public class SysStaffApiImpl implements SysStaffApi {

    @Resource
    private SysStaffMapper sysStaffMapper;

    @Override
    @PostMapping("getByCode")
    public SysStaff getByCode(@RequestBody SysStaff code) {
        LambdaQueryWrapper<SysStaff> wrapper = new LambdaQueryWrapper<>(code);
        return sysStaffMapper.selectOne(wrapper);
    }

    @Override
    @PostMapping("getByCodeList")
    public List<SysStaff> getByCodeList(@RequestBody SysStaff sysStaff) {
        LambdaQueryWrapper<SysStaff> wrapper = new LambdaQueryWrapper<>(sysStaff);
        return sysStaffMapper.selectList(wrapper);
    }

    @Override
    @PostMapping("insert")
    public int insert(@RequestBody SysStaff sysStaff) {
        return sysStaffMapper.insert(sysStaff);
    }
}
