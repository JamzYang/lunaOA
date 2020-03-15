package com.sjz.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjz.modules.sys.vo.SysUserVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.sys.dao.SysUserDao;
import com.sjz.modules.sys.entity.SysUserEntity;
import com.sjz.modules.sys.service.SysUserService;


@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUserEntity> page = this.page(
                new Query<SysUserEntity>().getPage(params),
                new QueryWrapper<SysUserEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils selectPageVo(Map<String, Object> params) {
        IPage<SysUserVO> page = baseMapper.selectPageVo(new Query<SysUserEntity>().getPage(params), 1);
        return new PageUtils(page);
    }


    @Override
    public SysUserEntity queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }

    @Override
    public List<Long> queryAllMenuId(Integer userId) {
        return baseMapper.queryAllMenuId(userId);
    }

}
