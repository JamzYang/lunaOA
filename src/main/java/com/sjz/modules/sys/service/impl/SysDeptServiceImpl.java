package com.sjz.modules.sys.service.impl;

import com.sjz.modules.sys.vo.SysDeptVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjz.common.utils.PageUtils;
import com.sjz.common.utils.Query;

import com.sjz.modules.sys.dao.SysDeptDao;
import com.sjz.modules.sys.entity.SysDeptEntity;
import com.sjz.modules.sys.service.SysDeptService;


@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDeptEntity> page = this.page(
                new Query<SysDeptEntity>().getPage(params),
                new QueryWrapper<SysDeptEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public SysDeptVO queryDeptTree() {
        List<SysDeptEntity> allDepts = baseMapper.queryAll();
        SysDeptVO deptTree = toDeptTree(allDepts);
        return deptTree;
    }

    private SysDeptVO toDeptTree(List<SysDeptEntity> allDepts) {
        SysDeptVO deptTree = new SysDeptVO();

        for (SysDeptEntity dept : allDepts) {
            if(0 == dept.getPid()){
                deptTree.setLevel(0);
                deptTree.setId(dept.getDeptId());
                deptTree.setLabel(dept.getName());
                deptTree.setName(dept.getName());
                deptTree.setPid(0);
                List<SysDeptVO> children = findChildren(deptTree, allDepts,0);
                deptTree.setChildren(children);
                break;
            }
        }
        return deptTree;
    }

    private List<SysDeptVO> findChildren(SysDeptVO deptTree, List<SysDeptEntity> allDepts, int level) {
        List<SysDeptVO> children = new ArrayList<>();
        for (SysDeptEntity dept : allDepts) {
            if(dept.getPid() == deptTree.getId()){
                SysDeptVO child = new SysDeptVO();
                child.setLevel(deptTree.getLevel()+1);
                child.setId(dept.getDeptId());
                child.setLabel(dept.getName());
                child.setName(dept.getName());
                child.setPid(deptTree.getId());
                children.add(child);
            }
            if(children == null){
                return null;
            }
        }
        for (SysDeptVO deptTree1 : children) {
            List<SysDeptVO> children1 = findChildren(deptTree1, allDepts, 0);
            deptTree1.setChildren(children1);
        }
        return children;
    }


}
