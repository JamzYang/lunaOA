package com.sjz.modules.sys.vo;

import com.sjz.modules.sys.entity.SysRoleEntity;
import lombok.Data;

import java.util.List;

/**
 * @author yang
 * Date 2020/3/16 12:13
 */
@Data
public class SysRoleTreeVO2 {
    private int pid;
    private String name;
    private List<RoleVO2> list;
}
