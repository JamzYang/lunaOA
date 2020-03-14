package com.sjz.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjz.common.utils.PageUtils;
import com.sjz.modules.sys.entity.SysRoleEntity;
import com.sjz.modules.sys.vo.SysRoleTreeVO;

import java.util.List;
import java.util.Map;

/**
 * 角色表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SysRoleTreeVO> queryAll();
    List<SysRoleTreeVO> getRoleTypeList();

    List<SysRoleEntity> getRoleByType(int roleType);
}

