package com.sjz.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjz.modules.sys.entity.SysSceneEntity;
import com.sjz.modules.sys.service.SysSceneService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 场景
 *
 * @author yang
 * @email
 * @date 2020-03-16 17:07:38
 */
@RestController
@RequestMapping("sys/scene")
public class SysSceneController {
    @Autowired
    private SysSceneService sysSceneService;

    /**
     * 按类型查场景
     */
    @PostMapping("/list")
    public R queryScene(@RequestParam int type){
        List<SysSceneEntity> list = sysSceneService.queryAll(type);
        return R.ok().put("data", list);
    }

    /**
     * 列表
     */
//    @PostMapping("/list")
////    @RequiresPermissions("sys:scene:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = sysSceneService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    @PostMapping("/info/{sceneId}")
    @RequiresPermissions("sys:scene:info")
    public R info(@PathVariable("sceneId") Integer sceneId){
		SysSceneEntity sysScene = sysSceneService.getById(sceneId);

        return R.ok().put("sysScene", sysScene);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("sys:scene:save")
    public R save(@RequestBody SysSceneEntity sysScene){
		sysSceneService.save(sysScene);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("sys:scene:update")
    public R update(@RequestBody SysSceneEntity sysScene){
		sysSceneService.updateById(sysScene);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("sys:scene:delete")
    public R delete(@RequestBody Integer[] sceneIds){
		sysSceneService.removeByIds(Arrays.asList(sceneIds));
        return R.ok();
    }

}
