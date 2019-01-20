package com.xll.upms.admin.model.dto;

import com.xll.upms.admin.model.entity.SysRole;
import lombok.Data;

/**
 * @Author 徐亮亮
 * @Description： 角色DTO
 * @Date 2019/1/18 21:46
 */
@Data
public class RoleDTO extends SysRole {
    /**
     * 角色部门Id
     */
    private Integer roleDeptId;

    /**
     * 部门名称
     */
    private String deptName;
}
