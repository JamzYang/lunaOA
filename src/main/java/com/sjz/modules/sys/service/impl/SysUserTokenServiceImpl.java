package com.sjz.modules.sys.service.impl;

import com.sjz.common.utils.R;
import com.sjz.modules.sys.oauth2.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.sys.dao.SysUserTokenDao;
import com.sjz.modules.sys.entity.SysUserTokenEntity;
import com.sjz.modules.sys.service.SysUserTokenService;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {
    private long EXPIRE = 60 * 30;

    @Autowired
    private SysUserTokenDao sysUserTokenDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUserTokenEntity> page = this.page(
                new Query<SysUserTokenEntity>().getPage(params),
                new QueryWrapper<SysUserTokenEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R createToken(Integer userId) {
        String token = TokenGenerator.generateValue();
        Date expireTime = new Date(System.currentTimeMillis()+EXPIRE * 1000);
        SysUserTokenEntity tokenEntity = getById(userId);
        if(tokenEntity == null){
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setExpireTime(expireTime);
            save(tokenEntity);
        }else{
            token = tokenEntity.getToken();
            tokenEntity.setUpdateTime(new Date());
            tokenEntity.setExpireTime(expireTime);
            updateById(tokenEntity);
        }
        R r = R.ok().put("token",token);
        return r;
    }

    @Override
    public void logout(String token) {
        sysUserTokenDao.delByToken(token);
    }

}
