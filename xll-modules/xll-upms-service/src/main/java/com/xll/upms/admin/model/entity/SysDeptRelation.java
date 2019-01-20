package com.xll.upms.admin.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 徐亮亮
 * @Description：  部门关系实体类
 * @Date 2019/1/18 21:48
 */
@Data
@TableName("sys_dept_relation")
public class SysDeptRelation extends Model<SysDeptRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 祖先节点
     */
	private Integer ancestor;
    /**
     * 后代节点
     */
	private Integer descendant;


	@Override
	protected Serializable pkVal() {
		return this.ancestor;
	}

	@Override
	public String toString() {
		return "SysDeptRelation{" +
			", ancestor=" + ancestor +
			", descendant=" + descendant +
			"}";
	}
}
