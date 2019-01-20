package com.xll.upms.monitor.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 徐亮亮
 * @Description：  监控手机属性配置类
 * @Date 2019/1/18 22:04
 */
@Data
@ConditionalOnExpression("!'${mobiles}'.isEmpty()")
public class MonitorMobilePropertiesConfig {
    private Boolean enabled;
    private List<String> mobiles = new ArrayList<>();
}
