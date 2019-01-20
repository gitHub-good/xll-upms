package com.xll.upms.gateway.service.impl;

import com.xll.upms.common.vo.MenuVO;
import com.xll.upms.gateway.feign.MenuService;
import com.xll.upms.gateway.service.PermissionService;
import com.xiaoleilu.hutool.collection.CollUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author 徐亮亮
 * @Description： 允许业务逻辑
 * @Date 2019/1/18 21:16
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private MenuService menuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        //ele-admin options 跨域配置，现在处理是通过前端配置代理，不使用这种方式，存在风险
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
//            return true;
//        }
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> authorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        AtomicBoolean hasPermission = new AtomicBoolean(false);

        if (principal != null) {
            if (CollUtil.isEmpty(authorityList)) {
                log.warn("角色列表为空：{}", authentication.getPrincipal());
                return false;
            }

            Set<MenuVO> urls = new HashSet<>();
            authorityList.stream().filter(authority ->
                    !StrUtil.equals(authority.getAuthority(), "ROLE_USER"))
                    .forEach(authority -> {
                        Set<MenuVO> menuVOSet = menuService.findMenuByRole(authority.getAuthority());
                        CollUtil.addAll(urls, menuVOSet);
                    });

            urls.stream().filter(menu -> StrUtil.isNotEmpty(menu.getUrl())
                    && antPathMatcher.match(menu.getUrl(), request.getRequestURI())
                    && request.getMethod().equalsIgnoreCase(menu.getMethod()))
                    .findFirst().ifPresent(menuVO -> hasPermission.set(true));
        }
        return hasPermission.get();
    }
}
