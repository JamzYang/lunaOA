package com.sjz.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sjz.modules.sys.entity.SysFieldEntity;
import com.sjz.modules.sys.service.SysFieldService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 自定义字段表
 *
 * @author yang
 * @email
 * @date 2020-03-16 19:37:53
 */
@RestController
@RequestMapping("sys/field")
public class SysFieldController {
    @Autowired
    private SysFieldService sysFieldService;

    /**
     * 查表头
     */
    @PostMapping("/queryListHead")
    @RequiresPermissions("sys:field:list")
    public R queryListHead(@RequestParam int label){
        List<SysFieldEntity> list = sysFieldService.queryListHead(label);

        return R.ok().put("data", list);
    }



    /**
     * 列表
     */
    @RequestMapping("/queryField")
    @RequiresPermissions("sys:field:list")
    public R list(int label, int id){
        List<SysFieldEntity> list = sysFieldService.queryListHead(label);
        return R.ok().put("data", list);
    }

    /**
     *表单字段校验
     * @param types 前端的types对应后端label, 字段所属的表
     */
    @PostMapping("/verify")
    @RequiresPermissions("sys:field:list")
    public R verify(String fieldName, String val, int types){
        SysFieldEntity field = new SysFieldEntity();
        field.setFieldName(fieldName);
        field.setLabel(types);
        field.setName(val);
        SysFieldEntity entity = sysFieldService.getOne(new QueryWrapper<>(field));
        if(entity != null){
            return R.error(500,"客户名称重复");
        }
        return R.ok();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{fieldId}")
    @RequiresPermissions("sys:field:info")
    public R info(@PathVariable("fieldId") Integer fieldId){
		SysFieldEntity sysField = sysFieldService.getById(fieldId);

        return R.ok().put("sysField", sysField);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:field:save")
    public R save(@RequestBody SysFieldEntity sysField){
		sysFieldService.save(sysField);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:field:update")
    public R update(@RequestBody SysFieldEntity sysField){
		sysFieldService.updateById(sysField);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:field:delete")
    public R delete(@RequestBody Integer[] fieldIds){
		sysFieldService.removeByIds(Arrays.asList(fieldIds));

        return R.ok();
    }

}
