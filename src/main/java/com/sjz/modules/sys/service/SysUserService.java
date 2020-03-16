package com.sjz.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.PageUtils2;
import com.sjz.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
public interface SysUserService extends IService<SysUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils2 selectPageVo(Map<String, Object> params);

    SysUserEntity queryByUserName(String username);

    List<Long> queryAllMenuId(Integer userId);


}

