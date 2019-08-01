package net.liuzd.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.SysRole;

public class SysRoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectByPrimaryKey() {

        execute((SqlSession session) -> {
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            SysRole bean = mapper.selectByPrimaryKey(1L);
            Assert.assertNotNull(bean);
            System.out.println(">>>" + bean);
            Assert.assertEquals("管理员", bean.getRoleName());
        });

    }

    @Test
    public void testSelectXmlByPrimaryKey() {
        execute((SqlSession session) -> {
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            SysRole bean = mapper.selectXmlByPrimaryKey(1L);
            Assert.assertNotNull(bean);
            System.out.println(">>>" + bean);
            Assert.assertEquals("管理员", bean.getRoleName());
        });
    }

    @Test
    public void testSelectById() {
        execute((SqlSession session) -> {
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            SysRole bean = mapper.selectById(1L);
            Assert.assertNotNull(bean);
            System.out.println(">>>" + bean);
            Assert.assertEquals("管理员", bean.getRoleName());
        });
    }

    @Test
    public void testSelectAll() {
        execute((SqlSession session) -> {
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            List<SysRole> beans = mapper.selectAll();
            Assert.assertNotNull(beans);
            Assert.assertTrue(beans.size() > 0);
            beans.stream().forEach(bean -> {
                System.out.println(">>>" + bean);
            });
        });
    }

    @Test
    public void testInsert() {
        //
        SqlSession session = getSqlSession();

        try {
            //
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);

            SysRole bean = new SysRole();
            bean.setCreateBy("zhain");
            bean.setCreateTime(new Date());
            bean.setEnabled(false);
            bean.setRoleName("test role");

            // 这里的返回值result是执行的SQL影响的行数
            int result = mapper.insert(bean);
            // 只插入1条数据
            Assert.assertEquals(1, result);
            // id为null,没有给id赋值，并且没有配置回写id的值
            Assert.assertNull(bean.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 默认的sqlSessionFactory.openSession()是不自动提交的
            // 因此不手动执行commit也不会提交到数据库
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testInsertUseGeneratedKeys() {
        //
        SqlSession session = getSqlSession();

        try {
            //
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);

            SysRole bean = new SysRole();
            bean.setCreateBy("zhain");
            bean.setCreateTime(new Date());
            bean.setEnabled(false);
            bean.setRoleName("test role");

            // 这里的返回值result是执行的SQL影响的行数
            int result = mapper.insertUseGeneratedKeys(bean);
            // 只插入1条数据
            Assert.assertEquals(1, result);
            // 返回自增主键
            System.out.println("id : "+bean.getId());
            // 配置回写id的值
            Assert.assertNotNull(bean.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 默认的sqlSessionFactory.openSession()是不自动提交的
            // 因此不手动执行commit也不会提交到数据库
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testInsertUseSelectKey() {
        //返回非自增主键
        SqlSession session = getSqlSession();

        try {
            //
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);

            SysRole bean = new SysRole();
            bean.setCreateBy("zhain");
            bean.setCreateTime(new Date());
            bean.setEnabled(false);
            bean.setRoleName("test role");

            // 这里的返回值result是执行的SQL影响的行数
            int result = mapper.insertUseSelectKey(bean);
            // 只插入1条数据
            Assert.assertEquals(1, result);
            // 返回自增主键
            System.out.println("id : "+bean.getId());
            // 返回非自增主键
            Assert.assertNotNull(bean.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 默认的sqlSessionFactory.openSession()是不自动提交的
            // 因此不手动执行commit也不会提交到数据库
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();

        try {
            //
            SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole = mapper.selectById(1L);
            System.out.println(">>>" + sysRole);
            Assert.assertEquals("管理员", sysRole.getRoleName());

            String roleName = "超级管理员";
            sysRole.setRoleName(roleName);
            // 这里的返回值result是执行的SQL影响的行数
            //入库成乱码了
            int result = mapper.updateById(sysRole);
            // 只更新1条数据
            Assert.assertEquals(1, result);
            sysRole = mapper.selectByPrimaryKey(1L);
            //返回怎么是乱码了
            //[再见乱码：5分钟读懂MySQL字符集设置](https://www.cnblogs.com/chyingp/p/mysql-character-set-collation.html)
            //只是没重启系统了，之后再验证。
            Assert.assertEquals(roleName, sysRole.getRoleName());
            //
        } finally {
           //sqlSession.commit(true);
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById() {
        execute((SqlSession session) -> {
            //
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            SysRole sysRole = mapper.selectByPrimaryKey(1L);
            Assert.assertNotNull(sysRole);

            // 这里是直接根据id删除
            int result = mapper.deleteById(1L);
            // 只删除1条数据
            Assert.assertEquals(1, result);
            Assert.assertNull(mapper.selectByPrimaryKey(1L));
            // -
        });
    }

}