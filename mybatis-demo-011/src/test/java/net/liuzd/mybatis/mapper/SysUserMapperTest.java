package net.liuzd.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import net.liuzd.mybatis.model.SysRole;
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
                for (SysRole sysRole : sysUser.getSysRoleList()) {
                    System.out.println("角色名：" + sysRole.getRoleName());
                }
            }
        });

    }

}