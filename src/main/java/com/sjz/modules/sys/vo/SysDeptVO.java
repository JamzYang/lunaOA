package com.sjz.modules.sys.vo;

import lombok.Data;

import java.util.List;

/**
 * @author yang
 * Date 2020/3/13 8:47
 * 用于生成部门树
 */
@Data
public class SysDeptVO {
    private int level;
    private int pid;
    private int id ;
    private String label;
    private String name;
    private List<SysDeptVO> children;
}
