package com.xll.upms.admin.service;


import com.baomidou.mybatisplus.service.IService;
import com.xll.upms.admin.model.entity.SysRoleMenu;

/**
 * @Author 徐亮亮
 * @Description：  角色菜单表 服务类
 * @Date 2019/1/18 21:57
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 更新角色菜单
     *
     *
     * @param role
     * @param roleId  角色
     * @param menuIds 菜单列表
     * @return
     */
    Boolean insertRoleMenus(String role, Integer roleId, String menuIds);
}
