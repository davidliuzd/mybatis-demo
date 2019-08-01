package net.liuzd.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.SysUserExtend;

public class SysUserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectUserAndRoleById() {

        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 注意这里使用1001这个用户，因为这个用户只有1个角色
            SysUserExtend sysUserExtend = mapper.selectUserAndRoleById(1001L);
            Assert.assertNotNull(sysUserExtend);
            Assert.assertNotNull(sysUserExtend.getSysRole());
        });

    }

    @Test
    public void testSelectUserAndRoleByIdResultMap() {

        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 注意这里使用1001这个用户，因为这个用户只有1个角色
            SysUserExtend sysUserExtend = mapper.selectUserAndRoleByIdResultMap(1001L);
            Assert.assertNotNull(sysUserExtend);
            Assert.assertNotNull(sysUserExtend.getSysRole());
        });

    }

    @Test
    public void testSelectUserAndRoleByIdResultMapOfExtend() {

        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 注意这里使用1001这个用户，因为这个用户只有1个角色
            SysUserExtend sysUserExtend = mapper.selectUserAndRoleByIdResultMapOfExtend(1001L);
            Assert.assertNotNull(sysUserExtend);
            Assert.assertNotNull(sysUserExtend.getSysRole());
        });

    }

    @Test
    public void testAssociationSelectUserAndRoleByIdResultMapOfExtend() {

        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 注意这里使用1001这个用户，因为这个用户只有1个角色
            SysUserExtend sysUserExtend = mapper.associationSelectUserAndRoleByIdResultMapOfExtend(1001L);
            Assert.assertNotNull(sysUserExtend);
            Assert.assertNotNull(sysUserExtend.getSysRole());
        });

    }

    @Test
    public void testAssociationSelectUserAndRoleByIdResultMapOfReference() {

        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 注意这里使用1001这个用户，因为这个用户只有1个角色
            SysUserExtend sysUserExtend = mapper.associationSelectUserAndRoleByIdResultMapOfReference(1001L);
            Assert.assertNotNull(sysUserExtend);
            Assert.assertNotNull(sysUserExtend.getSysRole());
        });

    }

}