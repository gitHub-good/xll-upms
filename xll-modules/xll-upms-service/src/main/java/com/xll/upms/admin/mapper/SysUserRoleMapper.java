package com.xll.upms.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xll.upms.admin.model.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 徐亮亮
 * @Description： 用户角色表 Mapper 接口
 * @Date 2019/1/18 21:43
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
   /**
    * @Author 徐亮亮
    * @Description： 根据用户Id删除该用户的角色关系
    * @Date 2019/1/18 21:44
    */
    Boolean deleteByUserId(@Param("userId") Integer userId);
}