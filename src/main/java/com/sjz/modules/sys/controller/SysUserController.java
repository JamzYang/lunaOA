package com.sjz.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sjz.common.utils.PageUtils2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjz.modules.sys.entity.SysUserEntity;
import com.sjz.modules.sys.service.SysUserService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;

import javax.validation.Valid;


/**
 * 用户表
 *
 * @author yang
 * @email
 * @date 2019-12-04 21:27:42
 */
@Api(tags = "用户")
@RestController
@RequestMapping("sys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

//    /**
//     * 列表
//     */
//    @ApiOperation("列表")
//    @PostMapping("/list")
//    @RequiresPermissions("sys:user:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = sysUserService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }

    /**
     * 列表
     */
    @ApiOperation("列表")
    @PostMapping("/list")
    @RequiresPermissions("sys:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils2 page = sysUserService.selectPageVo(params);
        return R.ok().put("data", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public R info(@PathVariable("userId") Integer userId){
		SysUserEntity sysUser = sysUserService.getById(userId);

        return R.ok().put("sysUser", sysUser);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("sys:user:save")
    public R save(@Valid SysUserEntity sysUser){
		sysUserService.save(sysUser);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:sysuser:update")
    public R update(@RequestBody SysUserEntity sysUser){
		sysUserService.updateById(sysUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysuser:delete")
    public R delete(@RequestBody Integer[] userIds){
		sysUserService.removeByIds(Arrays.asList(userIds));
        return R.ok();
    }

}
