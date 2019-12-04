package com.sjz.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色菜单对应关系表
 * 
 * @author yang
 * @email 
 * @date 2019-12-04 21:27:42
 */
@Data
@TableName("sys_role_menu")
public class SysRoleMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 角色ID
	 */
	private Integer roleId;
	/**
	 * 菜单ID
	 */
	private Integer menuId;

}
