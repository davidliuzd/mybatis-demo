package net.liuzd.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import net.liuzd.mybatis.model.Enabled;
import net.liuzd.mybatis.model.SysRole;

public class SysRoleMapperTest extends BaseMapperTest {

    @Test
    public void testUpdateById() {

        execute((SqlSession session) -> {
            //
            SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
            //
            SysRole bean = mapper.selectRoleById(1L);
            Assert.assertEquals(Enabled.ENABLED, bean.getEnabled());
            //
            // 修改角色的enabled为disabled
            bean.setEnabled(Enabled.DISABLED);

            if (bean.getEnabled() == Enabled.DISABLED || bean.getEnabled() == Enabled.ENABLED) {
                mapper.updateById(bean);
                bean = mapper.selectRoleById(1L);
                Assert.assertEquals(Enabled.DISABLED, bean.getEnabled());
            } else {
                Assert.assertEquals(true,false);
            }
            //
        });

    }

}