package com.xll.upms.admin.service;


import com.baomidou.mybatisplus.service.IService;
import com.xll.upms.admin.model.entity.SysUserRole;

/**
 * @Author 徐亮亮
 * @Description：  用户角色表 服务类
 * @Date 2019/1/18 21:58
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     * @param userId 用户ID
     * @return boolean
     */
    Boolean deleteByUserId(Integer userId);
}
