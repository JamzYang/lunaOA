package com.sjz.modules.crm.dao;

import com.sjz.modules.crm.entity.CrmCustomerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户表
 * 
 * @author yang
 * @email 
 * @date 2020-03-16 19:38:43
 */
@Mapper
public interface CrmCustomerDao extends BaseMapper<CrmCustomerEntity> {
	
}
