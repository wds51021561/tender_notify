package com.yy.common.inter.api.ms.notice;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "${feign.ms.url}:")
public interface SysStaffApi {
}
