package net.liuzd.mybatis.mapper;

import java.util.List;

import net.liuzd.mybatis.model.SysUserExtend;

public interface SysUserMapper {

    /**
     * 获取所有的用户以及对应的所有角色
     *
     * @return
     */
    List<SysUserExtend> selectAllUserAndRoles();
}