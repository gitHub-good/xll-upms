package com.xll.upms.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xll.upms.admin.model.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author 徐亮亮
 * @Description：  部门管理 Mapper 接口
 * @Date 2019/1/18 21:38
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 关联dept——relation
     *
     * @param delFlag 删除标记
     * @return 数据列表
     */
    List<SysDept> selectDeptDtoList(String delFlag);
}