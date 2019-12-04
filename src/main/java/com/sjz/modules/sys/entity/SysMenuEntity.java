package com.sjz.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 后台菜单表
 * 
 * @author yang
 * @email 
 * @date 2019-12-04 21:27:42
 */
@Data
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 菜单ID
	 */
	@TableId
	private Integer menuId;
	/**
	 * 上级菜单ID
	 */
	private Integer parentId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 菜单类型  1目录 2 菜单 3 按钮 4特殊
	 */
	private Integer menuType;
	/**
	 * 菜单URL
	 */
	private String url;
	/**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	private String perms;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 菜单说明
	 */
	private String remarks;

}
