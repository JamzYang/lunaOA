package com.sjz;

import com.sjz.modules.sys.entity.SysDeptEntity;
import com.sjz.modules.sys.vo.SysDeptVO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * Date 2020/3/13 9:54
 */

public class ToDeptTreeTest {
    @Test
    public void queryDeptTree() {
        List<SysDeptEntity> allDepts = new ArrayList<>();
        SysDeptEntity dept1 = new SysDeptEntity();
        dept1.setDeptId(1);
        dept1.setPid(0);
        dept1.setName(dept1.getDeptId()+": 部门");
        allDepts.add(dept1);
        for (int i = 2; i < 6; i++) {
            SysDeptEntity dept2 = new SysDeptEntity();
            dept2.setDeptId(i);
            dept2.setPid(1);
            dept2.setName(dept2.getDeptId()+": 部门");
            allDepts.add(dept2);
            for (int j = 1; j < 5; j++) {
                SysDeptEntity dept3 = new SysDeptEntity();
                dept3.setDeptId(i*10 + j);
                dept3.setPid(dept2.getDeptId());
                dept3.setName(dept3.getDeptId()+": 部门");
                allDepts.add(dept3);
            }
        }
        SysDeptVO deptTree = toDeptTree(allDepts);
        System.out.println();
    }

    private SysDeptVO toDeptTree(List<SysDeptEntity> allDepts) {
        SysDeptVO deptTree = new SysDeptVO();

        for (SysDeptEntity dept : allDepts) {
            if(0 == dept.getPid()){
                deptTree.setLevel(0);
                deptTree.setId(dept.getDeptId());
                deptTree.setLabel(dept.getName());
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
