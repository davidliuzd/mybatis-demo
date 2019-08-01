package net.liuzd.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.SysUser;

public class SysUserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectByUser() {

        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 只按用户名查询
            SysUser query = new SysUser();
            //bind 标签可以使用 OGNL 表达式创建一个变量并将其绑定到上下文中
            //使用 bind 标签来避免由于更换数据库带来的一些麻烦
            query.setUserName("ad");
            List<SysUser> sysUserList = mapper.selectByUser(query);
            Assert.assertTrue(sysUserList.size() > 0);

            // 只按邮箱查询
            query = new SysUser();
            query.setUserEmail("test@mybatis.tk");
            sysUserList = mapper.selectByUser(query);
            Assert.assertTrue(sysUserList.size() > 0);

            // 同时按用户民和邮箱查询
            query = new SysUser();
            query.setUserName("ad");
            query.setUserEmail("test@mybatis.tk");
            sysUserList = mapper.selectByUser(query);
            // 由于没有同时符合这两个条件的用户，因此查询结果数为0
            Assert.assertTrue(sysUserList.size() == 0);
        });

    }

    @Test
    public void testUpdateByIdSelective() {
        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);

            SysUser sysUser = new SysUser();
            // 更新id=1的用户
            sysUser.setId(1L);
            // 修改邮箱
            sysUser.setUserEmail("test@mybatis.tk");

            int result = mapper.updateByIdSelective(sysUser);
            Assert.assertEquals(1, result);

            // 查询id=1的用户
            sysUser = mapper.selectById(1L);
            // 修改后的名字保持不变，但是邮箱变成了新的
            Assert.assertEquals("admin", sysUser.getUserName());
            Assert.assertEquals("test@mybatis.tk", sysUser.getUserEmail());
        });

    }

    @Test
    public void testInsertSelective() {
        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test-selective");
            sysUser.setUserPassword("123456");
            sysUser.setUserInfo("test info");
            sysUser.setCreateTime(new Date());
            mapper.insertSelective(sysUser);
            // 获取刚刚插入的数据
            sysUser = mapper.selectById(sysUser.getId());
            // 因为没有指定userEmail,所以用的是数据库的默认值
            Assert.assertEquals("test@mybatis.tk", sysUser.getUserEmail());
            //
        });

    }

}