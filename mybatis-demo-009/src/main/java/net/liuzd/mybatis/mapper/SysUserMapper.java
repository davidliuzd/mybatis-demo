package net.liuzd.mybatis.mapper;

import net.liuzd.mybatis.model.SysUserExtend;

public interface SysUserMapper {

    /**
     * 根据用户id获取用户信息和用户的角色信息
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleById(Long id);

    /**
     * 根据用户id获取用户信息和用户的角色信息
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleByIdResultMap(Long id);

    SysUserExtend selectUserAndRoleByIdResultMapOfExtend(Long id);

    SysUserExtend associationSelectUserAndRoleByIdResultMapOfExtend(Long id);
    
    SysUserExtend associationSelectUserAndRoleByIdResultMapOfReference(Long id);
}