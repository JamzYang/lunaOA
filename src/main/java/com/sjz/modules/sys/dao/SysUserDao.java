package com.sjz.modules.sys.dao;

import com.sjz.modules.sys.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Integer userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Integer userId);

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);
}
