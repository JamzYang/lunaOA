package com.sjz.modules.crm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.crm.dao.CrmCustomerDao;
import com.sjz.modules.crm.entity.CrmCustomerEntity;
import com.sjz.modules.crm.service.CrmCustomerService;


@Service("crmCustomerService")
public class CrmCustomerServiceImpl extends ServiceImpl<CrmCustomerDao, CrmCustomerEntity> implements CrmCustomerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CrmCustomerEntity> page = this.page(
                new Query<CrmCustomerEntity>().getPage(params),
                new QueryWrapper<CrmCustomerEntity>()
        );

        return new PageUtils(page);
    }

}
