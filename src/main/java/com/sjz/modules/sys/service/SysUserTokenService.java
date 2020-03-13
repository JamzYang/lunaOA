package com.sjz.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;
import com.sjz.modules.sys.entity.SysUserTokenEntity;

import java.util.Map;

/**
 * 系统用户Token
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R createToken(Integer userId);

    /**
     * 登出: 修改 token值
     * @param token
     */
    void logout(String token);
}

