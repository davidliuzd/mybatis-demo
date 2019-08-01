package net.liuzd.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.SysRole;
import net.liuzd.mybatis.model.SysRoleExtend;
import net.liuzd.mybatis.model.SysUser;

public class SysRoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole bean = mapper.selectByPrimaryKey(1L);
            Assert.assertNotNull(bean);
            Assert.assertEquals("管理员", bean.getRoleName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);

            List<SysRole> sysUserList = mapper.selectAll();

            Assert.assertNotNull(sysUserList);
            Assert.assertTrue(sysUserList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);

            List<SysRole> sysUserList = mapper.selectRolesByUserId(1L);

            Assert.assertNotNull(sysUserList);
            Assert.assertTrue(sysUserList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRoleUsersByUserId() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);

            List<SysRoleExtend> sysUserList = mapper.selectRoleUsersByUserId(1L);
            Assert.assertNotNull(sysUserList);
            Assert.assertTrue(sysUserList.size() > 0);
            sysUserList.stream().forEach(bean -> {
                System.out.println(bean);
            });
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);

            List<SysRole> sysUserList = mapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            Assert.assertNotNull(sysUserList);
            Assert.assertTrue(sysUserList.size() > 0);
            sysUserList.stream().forEach(bean -> {
                System.out.println(bean);
            });
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserAndRole() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
            SysUser user = new SysUser();
            user.setId(1L);
            SysRole role = new SysRole();
            role.setEnabled(true);
            List<SysRole> sysUserList = mapper.selectRolesByUserAndRole(user, role);
            Assert.assertNotNull(sysUserList);
            Assert.assertTrue(sysUserList.size() > 0);
            sysUserList.stream().forEach(bean -> {
                System.out.println(bean);
            });
        } finally {
            sqlSession.close();
        }
    }
}