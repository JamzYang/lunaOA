package com.sjz.modules.sys.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjz.modules.crm.entity.CrmCustomerEntity;
import com.sjz.modules.crm.service.CrmCustomerService;
import org.apache.commons.beanutils.BeanUtils;
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

    @Autowired
    private CrmCustomerService crmCustomerService;

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
    public R list(Integer label, Integer id){
       List<SysFieldEntity> list = sysFieldService.queryListHead(label);
        if (id != null){
            if ("1".equals(label)){
//                recordList = crmLeadsService.queryField(id);
            }
            if (2 == label){
                CrmCustomerEntity customerEntity = crmCustomerService.getById(id);
//                list.forEach(field ->{
//                    String fieldName = field.getFieldName();
//                    try {
//                        String value = BeanUtils.getProperty(customerEntity, fieldName);
//                        field.setValue(value);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    } catch (NoSuchMethodException e) {
//                        e.printStackTrace();
//                    }
//                });
                for (SysFieldEntity field : list) {
                    String fieldName = field.getFieldName();
                    try {
                        String value = BeanUtils.getProperty(customerEntity, fieldName);
                        field.setValue(value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        continue;
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        continue;
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                        continue;
                    }
                }
            }
            if ("3".equals(label)){
//                recordList = crmContactsService.queryField(id);
            }
            if ("4".equals(label)){
//                recordList = crmProductService.queryField(id);
            }
            if ("5".equals(label)){
//                recordList = crmBusinessService.queryField(id);
            }
            if ("6".equals(label)){
//                recordList = crmContractService.queryField(id);
            }
            if ("7".equals(label)){
//                recordList = crmReceivablesService.queryField(id);
            }
            if ("8".equals(label)){
//                recordList = crmReceivablesPlanService.queryField(id);
            }
            if("10".equals(label)){
//                recordList = oaExamineCategoryService.queryField(id);
            }
        }else {
            if ("8".equals(label)){
//                recordList = crmReceivablesPlanService.queryField();
            }else {
//                recordList = adminFieldService.queryAddField(Integer.valueOf(label));
            }
        }
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
