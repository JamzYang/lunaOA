package com.sjz.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.sys.dao.SysDeptDao;
import com.sjz.modules.sys.entity.SysDeptEntity;
import com.sjz.modules.sys.service.SysDeptService;


@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDeptEntity> page = this.page(
                new Query<SysDeptEntity>().getPage(params),
                new QueryWrapper<SysDeptEntity>()
        );

        return new PageUtils(page);
    }

}