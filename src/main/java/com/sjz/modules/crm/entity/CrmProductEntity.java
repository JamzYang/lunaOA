package com.sjz.modules.crm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 产品表
 * 
 * @author yang
 * @email 
 * @date 2020-03-16 19:38:43
 */
@Data
@TableName("crm_product")
public class CrmProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer productId;
	/**
	 * 产品名称
	 */
	private String name;
	/**
	 * 产品编码
	 */
	private String num;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 状态 1 上架 0 下架
	 */
	private Integer status;
	/**
	 * 产品分类ID
	 */
	private Integer categoryId;
	/**
	 * 产品描述
	 */
	private String description;
	/**
	 * 创建人ID
	 */
	private Integer createUserId;
	/**
	 * 负责人ID
	 */
	private Integer ownerUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 批次
	 */
	private String batchId;

}
