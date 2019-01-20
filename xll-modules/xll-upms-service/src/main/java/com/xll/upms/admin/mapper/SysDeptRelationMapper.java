package com.xll.upms.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xll.upms.admin.model.entity.SysDeptRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 徐亮亮
 * @Description： 部门关系 Mapper
 * @Date 2019/1/18 21:39
 */
@Mapper
public interface SysDeptRelationMapper extends BaseMapper<SysDeptRelation> {
    /**
     * 删除部门关系表数据
     *
     * @param id 部门ID
     */
    void deleteAllDeptRealtion(Integer id);

    /**
     * 更改部分关系表数据
     *
     * @param deptRelation
     */
    void updateDeptRealtion(SysDeptRelation deptRelation);
}