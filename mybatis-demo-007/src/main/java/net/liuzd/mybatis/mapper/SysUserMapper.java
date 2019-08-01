package net.liuzd.mybatis.mapper;

import java.util.List;

import net.liuzd.mybatis.model.SysUser;

public interface SysUserMapper {

    /**
     * 根据用户id或用户名查询
     * @param sysUser
     * @return
     */
    SysUser selectByIdOrUserName(SysUser sysUser);

    /**
     * 根据动态条件查询用户信息(使用Where标签)
     * @param sysUser
     * @return
     */
    List<SysUser> selectByUserWhere(SysUser sysUser);

    /**
     * 根据主键选择性更新用户信息(使用Set标签)
     * @param sysUser
     * @return
     */
    int updateByIdSelectiveSet(SysUser sysUser);

    SysUser selectById(long l);

}