package net.liuzd.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import net.liuzd.mybatis.model.SysPrivilege;
import net.liuzd.mybatis.model.SysRoleExtend;
import net.liuzd.mybatis.model.SysUserExtend;

public class SysUserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAllUserAndRoles() {

        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            List<SysUserExtend> sysUserList = mapper.selectAllUserAndRoles();
            System.out.println("用户数：" + sysUserList.size());
            for (SysUserExtend sysUser : sysUserList) {
                System.out.println("用户名：" + sysUser.getUserName());
                for (SysRoleExtend sysRoleExtend : sysUser.getSysRoleList()) {
                    System.out.println("角色名：" + sysRoleExtend.getRoleName());
                    for (SysPrivilege sysPrivilege : sysRoleExtend.getSysPrivilegeList()) {
                        System.out.println("权限名：" + sysPrivilege.getPrivilegeName());
                    }
                }
            }
        });

    }

    @Test
    public void testSelectAllUserAndRolesSelect() {
        // 延迟加载
        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            //
            SysUserExtend sysUserExtend = mapper.selectAllUserAndRolesSelect(1L);
            System.out.println("用户名：" + sysUserExtend.getUserName());
            for (SysRoleExtend sysRoleExtend : sysUserExtend.getSysRoleList()) {
                System.out.println("角色名：" + sysRoleExtend.getRoleName());
                for (SysPrivilege sysPrivilege : sysRoleExtend.getSysPrivilegeList()) {
                    System.out.println("权限名：" + sysPrivilege.getPrivilegeName());
                }
            }

        });

    }

}