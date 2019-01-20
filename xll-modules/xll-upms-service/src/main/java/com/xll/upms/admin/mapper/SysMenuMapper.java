package com.xll.upms.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xll.upms.admin.model.entity.SysMenu;
import com.xll.upms.common.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 徐亮亮
 * @Description： 菜单权限表 Mapper 接口
 * @Date 2019/1/18 21:40
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRoleName(@Param("role") String role);
}