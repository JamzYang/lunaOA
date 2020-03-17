package com.sjz.modules.crm.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjz.modules.crm.entity.CrmContactsEntity;
import com.sjz.modules.crm.service.CrmContactsService;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.R;



/**
 * 联系人表
 *
 * @author yang
 * @email
 * @date 2020-03-16 19:38:43
 */
@RestController
@RequestMapping("crm/contacts")
public class CrmContactsController {
    @Autowired
    private CrmContactsService crmContactsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("crm:contacts:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = crmContactsService.selectPageVo(params);
        return R.ok().put("data", page);
    }

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("crm:contacts:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = crmContactsService.queryPage(params);
//        return R.ok().put("data", page);
//    }

    /**
     * 信息
     */
    @RequestMapping("/info/{contactsId}")
    @RequiresPermissions("crm:contacts:info")
    public R info(@PathVariable("contactsId") Integer contactsId){
		CrmContactsEntity crmContacts = crmContactsService.getById(contactsId);

        return R.ok().put("crmContacts", crmContacts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("crm:contacts:save")
    public R save(@RequestBody CrmContactsEntity crmContacts){
		crmContactsService.save(crmContacts);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("crm:contacts:update")
    public R update(@RequestBody CrmContactsEntity crmContacts){
		crmContactsService.updateById(crmContacts);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("crm:contacts:delete")
    public R delete(@RequestBody Integer[] contactsIds){
		crmContactsService.removeByIds(Arrays.asList(contactsIds));

        return R.ok();
    }

}
