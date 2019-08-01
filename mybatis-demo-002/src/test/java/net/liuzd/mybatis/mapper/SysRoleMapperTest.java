package net.liuzd.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.SysRole;

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
}