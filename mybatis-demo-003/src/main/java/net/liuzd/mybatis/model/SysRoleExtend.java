package net.liuzd.mybatis.model;

public class SysRoleExtend extends SysRole {

    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public String toString() {
        return "SysRoleExtend [sysUser=" + sysUser + "]"+super.toString();
    }

}