package com.xll.upms.gateway.feign.fallback;

import com.xll.upms.common.vo.MenuVO;
import com.xll.upms.gateway.feign.MenuService;
import com.xiaoleilu.hutool.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author 徐亮亮
 * @Description： 按钮业务逻辑回调类
 * @Date 2019/1/18 21:14
 */
@Slf4j
@Service
public class MenuServiceFallbackImpl implements MenuService {
    @Override
    public Set<MenuVO> findMenuByRole(String role) {
        log.error("调用{}异常{}","findMenuByRole",role);
        return CollUtil.newHashSet();
    }
}
