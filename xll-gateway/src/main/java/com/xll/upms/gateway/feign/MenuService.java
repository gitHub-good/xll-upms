package com.xll.upms.gateway.feign;

import com.xll.upms.common.vo.MenuVO;
import com.xll.upms.gateway.feign.fallback.MenuServiceFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @Author 徐亮亮
 * @Description： 调度服务upms接口
 * @Date 2019/1/18 21:15
 */
@FeignClient(name = "xll-upms-service", fallback = MenuServiceFallbackImpl.class)
public interface MenuService {
    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @GetMapping(value = "/menu/findMenuByRole/{role}")
    Set<MenuVO> findMenuByRole(@PathVariable("role") String role);
}
