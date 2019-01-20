package com.xll.upms.admin.model.dto;

import com.xll.upms.admin.model.entity.SysUser;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 徐亮亮
 * @Description： 用户基础信息
 * @Date 2019/1/18 21:47
 */
@Data
public class UserInfo implements Serializable {
    /**
     * 用户基本信息
     */
    private SysUser sysUser;
    /**
     * 权限标识集合
     */
    private String[] permissions;

    /**
     * 角色集合
     */
    private String[] roles;
}
