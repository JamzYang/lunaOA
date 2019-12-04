package com.sjz.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 部门表
 * 
 * @author yang
 * @email 
 * @date 2019-12-04 21:27:42
 */
@Data
@TableName("sys_dept")
public class SysDeptEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer deptId;
	/**
	 * 父级ID 顶级部门为0
	 */
	private Integer pid;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 排序 越大越靠后
	 */
	private Integer num;
	/**
	 * 部门备注
	 */
	private String remark;

}
