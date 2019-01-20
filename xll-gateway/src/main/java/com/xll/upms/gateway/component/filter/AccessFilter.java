package com.xll.upms.gateway.component.filter;

import com.xll.upms.common.constant.SecurityConstants;
import com.xll.upms.gateway.util.RibbonVersionHolder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;

/**
 * @Author 徐亮亮
 * @Description： 在RateLimitPreFilter 之前执行，不然又空指针问题
 * @Date 2019/1/18 21:08
 */
@Component
public class AccessFilter extends ZuulFilter {
    @Value("${zuul.ribbon.metadata.enabled:false}")
    private boolean canary;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String version = requestContext.getRequest().getHeader(SecurityConstants.VERSION);
        if (canary && StrUtil.isNotBlank(version)) {
            RibbonVersionHolder.setContext(version);
        }

        requestContext.set("startTime", System.currentTimeMillis());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            requestContext.addZuulRequestHeader(SecurityConstants.USER_HEADER, authentication.getName());
            requestContext.addZuulRequestHeader(SecurityConstants.ROLE_HEADER, CollectionUtil.join(authentication.getAuthorities(), ","));
        }
        return null;
    }
}
