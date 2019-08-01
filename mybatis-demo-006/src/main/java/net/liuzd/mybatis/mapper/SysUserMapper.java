package net.liuzd.mybatis.mapper;

import java.util.List;

import net.liuzd.mybatis.model.SysUser;

public interface SysUserMapper {
    
    /**
     * 根据动态条件查询用户信息
     *
     * @param sysUser
     * @return
     */
    List<SysUser> selectByUser(SysUser sysUser);
    
    
    /**
     * 根据主键选择性更新用户信息
     *
     * @param sysUser
     * @return
     */
    int updateByIdSelective(SysUser sysUser);


    SysUser selectById(long id);
    
    /**
     * 根据传入的参数值动态插入列
     *
     * @param sysUser
     * @return
     */
    int insertSelective(SysUser sysUser);
   
}