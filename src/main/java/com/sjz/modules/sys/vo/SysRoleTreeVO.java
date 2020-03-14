package com.sjz.modules.sys.vo;

import com.sjz.modules.sys.entity.SysRoleEntity;
import lombok.Data;

import java.util.List;

/**
 * @author yang
 * Date 2020/3/13 16:59
 * 用于生成权限树
 */
@Data
public class SysRoleTreeVO {
    private int roleType;
    private String name;
    private List<SysRoleEntity> list;
}
