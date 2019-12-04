package com.sjz.common.utils;

import com.sjz.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;

public class CurrentUser {
    public static Integer getUserId(){
        SysUserEntity curUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
       return curUser.getUserId();
    }
}
