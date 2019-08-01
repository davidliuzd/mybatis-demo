package net.liuzd.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.SysUser;

public class SysUserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectByIdOrUserName() {

        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 按id查询
            SysUser query = new SysUser();
            query.setId(1L);
            query.setUserName("admin");
            SysUser sysUser = mapper.selectByIdOrUserName(query);
            Assert.assertNotNull(sysUser);

            // 只按userName查询
            query.setId(null);
            sysUser = mapper.selectByIdOrUserName(query);
            Assert.assertNotNull(sysUser);

            // id 和 userName 都为空
            query.setUserName(null);
            sysUser = mapper.selectByIdOrUserName(query);
            Assert.assertNull(sysUser);
        });

    }

    @Test
    public void testSelectByUserWhere() {
        //where标签的作用：如果该标签包含的元素中有返回值，就插入一个where，如果where后面的字符串是以AND或者OR开头的，就将它们剔除。
        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 只按用户名查询
            SysUser query = new SysUser();
            query.setUserName("ad");
            List<SysUser> sysUserList = mapper.selectByUserWhere(query);
            Assert.assertTrue(sysUserList.size() > 0);

            // 只按邮箱查询
            query = new SysUser();
            query.setUserEmail("test@mybatis.tk");
            sysUserList = mapper.selectByUserWhere(query);
            Assert.assertTrue(sysUserList.size() > 0);

            // 同时按用户民和邮箱查询
            query = new SysUser();
            query.setUserName("ad");
            query.setUserEmail("test@mybatis.tk");
            sysUserList = mapper.selectByUserWhere(query);
            // 由于没有同时符合这两个条件的用户，因此查询结果数为0
            Assert.assertTrue(sysUserList.size() == 0);
        });

    }
    
    @Test
    public void testUpdateByIdSelectiveSet() {
        //注意事项：为了避免所有的条件都不满足，生成的Sql语句没有set标签，因此在最后加上了id = #{id},这样必然存在的赋值
        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            SysUser sysUser = new SysUser();
            // 更新id=1的用户
            sysUser.setId(1L);
            // 修改邮箱
            sysUser.setUserEmail("test@mybatis.tk");

            int result = mapper.updateByIdSelectiveSet(sysUser);
            Assert.assertEquals(1, result);

            // 查询id=1的用户
            sysUser = mapper.selectById(1L);
            // 修改后的名字保持不变，但是邮箱变成了新的
            Assert.assertEquals("admin", sysUser.getUserName());
            Assert.assertEquals("test@mybatis.tk", sysUser.getUserEmail());
        });

    }

}