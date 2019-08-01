package net.liuzd.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.SysPrivilege;
import net.liuzd.mybatis.model.SysRole;
import net.liuzd.mybatis.model.SysRoleExtend;

public class SysRoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectRoleByUserIdChoose() {

        execute((SqlSession session) -> {
            //
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            //
            // 将id=2的角色的enabled赋值为0
            SysRole sysRole = mapper.selectRoleById(2L);
            sysRole.setEnabled(false);
            mapper.updateById(sysRole);

            // 获取用户id为1的角色
            List<SysRoleExtend> sysRoleExtendList = mapper.selectRoleByUserIdChoose(1L);
            for (SysRoleExtend item : sysRoleExtendList) {
                System.out.println("角色名：" + item.getRoleName());
                if (item.getId().equals(1L)) {
                    // 第一个角色存在权限信息
                    Assert.assertNotNull(item.getSysPrivilegeList());
                } else if (item.getId().equals(2L)) {
                    // 第二个角色的权限为null
                    Assert.assertNull(item.getSysPrivilegeList());
                    continue;
                }
                for (SysPrivilege sysPrivilege : item.getSysPrivilegeList()) {
                    System.out.println("权限名：" + sysPrivilege.getPrivilegeName());
                }
            }
            //
        });

    }

}