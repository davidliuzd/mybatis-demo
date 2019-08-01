package net.liuzd.mybatis.model;

import java.util.List;

public class SysUserExtend extends SysUser {
    /**
     * 用户的角色集合
     */
    private List<SysRoleExtend> sysRoleList;

    public List<SysRoleExtend> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRoleExtend> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }
}