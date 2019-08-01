package net.liuzd.mybatis.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.SysUser;

public class SysUserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectByIdList() {

        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            List<Long> idList = new ArrayList<Long>();
            idList.add(1L);
            idList.add(1001L);

            List<SysUser> userList = mapper.selectByIdList(idList);
            Assert.assertEquals(2, userList.size());
        });

    }

    @Test
    public void testSelectByParamsIdList() {

        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            List<Long> idList = new ArrayList<Long>();
            idList.add(1L);
            idList.add(1001L);
            List<SysUser> userList = mapper.selectByParamsIdList(idList);
            Assert.assertEquals(2, userList.size());
        });

    }

    @Test
    public void testSelectByArrayIdList() {

        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            List<SysUser> userList = mapper.selectByIdArray(new Long[] { 1L, 1001L });
            Assert.assertEquals(2, userList.size());
        });

    }

    @Test
    public void testInsertList() {

        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            //
            List<SysUser> sysUserList = new ArrayList<SysUser>();
            for (int i = 0; i < 2; i++) {
                SysUser sysUser = new SysUser();
                sysUser.setUserName("test" + i);
                sysUser.setUserPassword("123456");
                sysUser.setUserEmail("test@mybatis.tk");

                sysUserList.add(sysUser);
            }

            int result = mapper.insertList(sysUserList);

            for (SysUser sysUser : sysUserList) {
                System.out.println("id > " + sysUser.getId());
            }

            Assert.assertEquals(2, result);
        });

    }

    @Test
    public void testUpdateByMap() {

        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", 1L);
            map.put("user_email", "test@mybatis.tk");
            map.put("user_password", "12345678");

            Assert.assertEquals(1, mapper.updateByMap(map));

            SysUser sysUser = mapper.selectById(1L);
            Assert.assertEquals("test@mybatis.tk", sysUser.getUserEmail());
            Assert.assertEquals("12345678", sysUser.getUserPassword());
        });

    }

    @Test
    public void testDelByIdList() {

        execute((SqlSession session) -> {
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            List<Long> idList = new ArrayList<Long>();
            idList.add(1L);
            idList.add(1001L);
            int result = mapper.delByIdList(idList);
            Assert.assertEquals(2, result);
        });

    }

}