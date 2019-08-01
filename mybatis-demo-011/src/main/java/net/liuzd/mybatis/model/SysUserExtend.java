package net.liuzd.mybatis.model;

import java.util.List;

public class SysUserExtend extends SysUser {
    /**
     * 用户的角色集合
     */
    private List<SysRole> sysRoleList;

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }
}