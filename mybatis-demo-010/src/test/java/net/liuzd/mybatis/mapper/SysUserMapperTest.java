package net.liuzd.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.SysUserExtend;

public class SysUserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectUserAndRoleByIdSelect() {

        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 注意这里使用1001这个用户，因为这个用户只有1个角色
            SysUserExtend sysUserExtend = mapper.selectUserAndRoleByIdSelect(1001L);
            Assert.assertNotNull(sysUserExtend);
            System.out.println("调用sysUserExtend.getSysRole()");
            //延迟加载后，在这里面重新查询数据库
            Assert.assertNotNull(sysUserExtend.getSysRole());
        });

    }
    
    @Test
    public void testSelectUserAndRoleByIdSelectOfLazyLoadTriggerMethods() {
        //aggressiveLazyLoading默认为false (延迟加载)，在有些场景下需要加载所有数据，怎么办？
        //MyBatis提供了参数lazyLoadTriggerMethods，这个参数的含义是，当调用配置中的方法时，加载全部的延迟加载数据，默认值为“equals,clone,hashCode,toString”。
        execute((SqlSession session) -> {
            //
            SysUserMapper mapper = session.getMapper(SysUserMapper.class);
            // 注意这里使用1001这个用户，因为这个用户只有1个角色
            SysUserExtend sysUserExtend = mapper.selectUserAndRoleByIdSelect(1001L);
            Assert.assertNotNull(sysUserExtend);
           /* System.out.println("调用sysUserExtend.equals(null)");
            sysUserExtend.equals(null);*/
            /*System.out.println("调用sysUserExtend.hashCode()");
            sysUserExtend.hashCode();*/
            System.out.println("调用sysUserExtend.toString()");
            sysUserExtend.toString();
            //
            System.out.println("调用sysUserExtend.getSysRole()");
            //延迟加载后，在这里面重新查询数据库
            Assert.assertNotNull(sysUserExtend.getSysRole());
        });

    }


   
}