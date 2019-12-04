package com.sjz.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.modules.sys.entity.SysUserRoleEntity;

import java.util.Map;

/**
 * 用户角色对应关系表
 *
 * @author yang
 * @email 
 * @date 2019-12-04 21:27:42
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

