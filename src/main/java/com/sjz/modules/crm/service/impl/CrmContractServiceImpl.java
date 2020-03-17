package com.sjz.modules.crm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.crm.dao.CrmContractDao;
import com.sjz.modules.crm.entity.CrmContractEntity;
import com.sjz.modules.crm.service.CrmContractService;


@Service("crmContractService")
public class CrmContractServiceImpl extends ServiceImpl<CrmContractDao, CrmContractEntity> implements CrmContractService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CrmContractEntity> page = this.page(
                new Query<CrmContractEntity>().getPage(params),
                new QueryWrapper<CrmContractEntity>()
        );

        return new PageUtils(page);
    }

}
