package com.xll.upms.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xll.upms.admin.model.entity.SysRole;
import com.xll.upms.common.util.Query;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author 徐亮亮
 * @Description：  角色Mapper
 * @Date 2019/1/18 21:42
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询角色列表含有部门信息
     * @param query 查询对象
     * @param condition 条件
     * @return List
     */
    List<Object> selectRolePage(Query<Object> query, Map<String, Object> condition);

    /**
     * 通过部门ID查询角色列表
     *
     * @param deptId 部门ID
     * @return 角色列表
     */
    List<SysRole> selectListByDeptId(Integer deptId);
}