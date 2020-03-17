package com.sjz.modules.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.modules.crm.entity.CrmContractEntity;

import java.util.Map;

/**
 * 合同表
 *
 * @author yang
 * @email 
 * @date 2020-03-16 19:38:43
 */
public interface CrmContractService extends IService<CrmContractEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

