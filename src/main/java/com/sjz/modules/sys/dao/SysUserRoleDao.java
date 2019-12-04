package com.sjz.modules.sys.dao;

import com.sjz.modules.sys.entity.SysUserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色对应关系表
 * 
 * @author yang
 * @email 
 * @date 2019-12-04 21:27:42
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
	
}
