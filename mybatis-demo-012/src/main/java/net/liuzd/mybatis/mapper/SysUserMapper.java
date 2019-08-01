package net.liuzd.mybatis.mapper;

import java.util.List;

import net.liuzd.mybatis.model.SysUserExtend;

public interface SysUserMapper {

    /**
     * 获取所有的用户以及对应的所有角色
     * @return
     */
    List<SysUserExtend> selectAllUserAndRoles();

    /**
     * 通过嵌套查询获取指定用户的信息以及用户的角色和权限信息（ 延迟加载）
     * @param id
     * @return
     */
    SysUserExtend selectAllUserAndRolesSelect(Long id);
}