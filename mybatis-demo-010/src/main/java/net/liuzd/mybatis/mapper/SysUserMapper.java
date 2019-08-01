package net.liuzd.mybatis.mapper;

import net.liuzd.mybatis.model.SysUserExtend;

public interface SysUserMapper {

    /**
     * 根据用户id获取用户信息和用户的角色信息，嵌套查询方式
     *
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleByIdSelect(Long id);
}