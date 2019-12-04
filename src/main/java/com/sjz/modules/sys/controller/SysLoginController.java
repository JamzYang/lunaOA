package com.sjz.modules.sys.controller;

import com.sjz.common.utils.R;
import com.sjz.modules.sys.entity.SysUserEntity;
import com.sjz.modules.sys.service.SysUserService;
import com.sjz.modules.sys.service.SysUserTokenService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * Date 2019/12/4 20:11
 */

@RestController
@RequestMapping("/login")
public class SysLoginController {
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserTokenService tokenService;


    @PostMapping
    public R login(@RequestParam String username, String password){
        if(username == null || password == null){
            return R.error("用户名或密码不能为空");
        }
        SysUserEntity userEntity = userService.queryByUserName(username);
        if(userEntity == null || !verifyPassword(password,userEntity)){
            return R.error("用户名或密码错误");
        }

        R r = tokenService.createToken(userEntity.getUserId());
        return r;
    }


    private boolean verifyPassword(String inputtedPassword, SysUserEntity userEntity) {
        return userEntity.getPassword().equals(new Sha256Hash(inputtedPassword,userEntity.getSalt()).toHex());
    }

}
