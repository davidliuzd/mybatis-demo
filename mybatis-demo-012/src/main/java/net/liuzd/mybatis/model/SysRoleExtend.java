package net.liuzd.mybatis.model;

import java.util.List;

public class SysRoleExtend extends SysRole {
    /**
     * 角色包含的权限列表
     */
    private List<SysPrivilege> sysPrivilegeList;

    public List<SysPrivilege> getSysPrivilegeList() {
        return sysPrivilegeList;
    }

    public void setSysPrivilegeList(List<SysPrivilege> sysPrivilegeList) {
        this.sysPrivilegeList = sysPrivilegeList;
    }
}