package net.liuzd.mybatis.mapper;

import java.util.List;

import net.liuzd.mybatis.model.SysRole;
import net.liuzd.mybatis.model.SysRoleExtend;

public interface SysRoleMapper {

    SysRole selectRoleById(Long id);
    
    int updateById(SysRole record);
    
    /**
     * 根据用户id获取用户的角色信息
     *
     * @param userId
     * @return
     */
    List<SysRoleExtend> selectRoleByUserIdChoose(Long userId);

}