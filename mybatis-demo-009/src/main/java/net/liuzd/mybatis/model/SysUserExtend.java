package net.liuzd.mybatis.model;
public class SysUserExtend extends SysUser {
    /**
     * 用户角色
     */
    private SysRole sysRole;

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
}