package com.xll.upms.admin.model.dto;

import com.xll.upms.admin.model.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @Author 徐亮亮
 * @Description：  用户DTO
 * @Date 2019/1/18 21:47
 */
@Data
public class UserDTO extends SysUser {
    /**
     * 角色ID
     */
    private List<Integer> role;

    private Integer deptId;

    /**
     * 新密码
     */
    private String newpassword1;
}
