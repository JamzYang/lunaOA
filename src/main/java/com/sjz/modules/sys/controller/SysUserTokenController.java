package com.sjz.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjz.modules.sys.entity.SysUserTokenEntity;
import com.sjz.modules.sys.service.SysUserTokenService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 系统用户Token
 *
 * @author yang
 * @email 
 * @date 2019-12-04 21:27:42
 */
@RestController
@RequestMapping("sys/sysusertoken")
public class SysUserTokenController {
    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysusertoken:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserTokenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:sysusertoken:info")
    public R info(@PathVariable("userId") Integer userId){
		SysUserTokenEntity sysUserToken = sysUserTokenService.getById(userId);

        return R.ok().put("sysUserToken", sysUserToken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysusertoken:save")
    public R save(@RequestBody SysUserTokenEntity sysUserToken){
		sysUserTokenService.save(sysUserToken);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysusertoken:update")
    public R update(@RequestBody SysUserTokenEntity sysUserToken){
		sysUserTokenService.updateById(sysUserToken);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysusertoken:delete")
    public R delete(@RequestBody Integer[] userIds){
		sysUserTokenService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
