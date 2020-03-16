package com.sjz.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 场景
 * 
 * @author yang
 * @email 
 * @date 2020-03-16 17:07:38
 */
@Data
@TableName("sys_scene")
public class SysSceneEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer sceneId;
	/**
	 * 分类
	 */
	private Integer type;
	/**
	 * 场景名称
	 */
	private String name;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 排序ID
	 */
	private Integer sort;
	/**
	 * 属性值
	 */
	private String data;
	/**
	 * 1隐藏
	 */
	private Integer isHide;
	/**
	 * 1系统0自定义
	 */
	private Integer isSystem;
	/**
	 * 系统参数
	 */
	private String bydata;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
