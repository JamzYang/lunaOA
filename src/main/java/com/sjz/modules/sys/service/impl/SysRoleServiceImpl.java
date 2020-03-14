package com.sjz.modules.sys.service.impl;

import com.sjz.modules.sys.vo.SysRoleTreeVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.sys.dao.SysRoleDao;
import com.sjz.modules.sys.entity.SysRoleEntity;
import com.sjz.modules.sys.service.SysRoleService;


@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysRoleEntity> page = this.page(
                new Query<SysRoleEntity>().getPage(params),
                new QueryWrapper<SysRoleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SysRoleTreeVO> queryAll() {
        List<SysRoleEntity> allRoles = baseMapper.queryAll();
        List<SysRoleTreeVO> roleTree = getRoleTypeList();
        for (SysRoleEntity role : allRoles) {
            for(SysRoleTreeVO roleTreeVO: roleTree ){
                if(roleTreeVO.getRoleType() == role.getRoleType()){
                    if(roleTreeVO.getList() == null){
                        List<SysRoleEntity> list = new ArrayList<>();
                        roleTreeVO.setList(list);
                    }
                    roleTreeVO.getList().add(role);
                }
            }
        }
        return roleTree;
    }

    @Override
    public List<SysRoleTreeVO> getRoleTypeList() {
        List<SysRoleTreeVO> roleTypeList = new ArrayList<>();
        SysRoleTreeVO sysManage = new SysRoleTreeVO();
        sysManage.setName("系统管理角色");
        sysManage.setRoleType(1);
        SysRoleTreeVO custManage = new SysRoleTreeVO();
        custManage.setName("客户管理角色");
        custManage.setRoleType(2);
        roleTypeList.add(sysManage);
        roleTypeList.add(custManage);
        return roleTypeList;
    }

    @Override
    public List<SysRoleEntity> getRoleByType(int roleType) {
        QueryWrapper<SysRoleEntity> wrapper = new QueryWrapper<>();
        SysRoleEntity role = new SysRoleEntity();
        role.setRoleType(roleType);
        wrapper.setEntity(role);
        List<SysRoleEntity> roles = baseMapper.selectList(wrapper);
        return roles;
    }

    /**
     * 将
     * @param type
     * @return
     */
    private String roleTypeCaseName(Integer type) {
        String name;
        switch (type) {
            case 1:
                name = "系统管理角色";
                break;
            case 2:
                name = "客户管理角色";
                break;
            case 7:
                name = "办公管理角色";
                break;
            case 8:
                name = "项目管理角色";
                break;
            default:
                name = "自定义角色";
        }
        return name;
    }
}
