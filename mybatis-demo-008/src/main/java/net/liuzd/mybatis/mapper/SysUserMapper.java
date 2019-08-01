package net.liuzd.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import net.liuzd.mybatis.model.SysUser;

public interface SysUserMapper {

    /**
     * 根据用户id集合查询用户
     * @param idList
     * @return
     */
    List<SysUser> selectByIdList(List<Long> idList);

    /**
     * 根据用户id集合查询用户
     * @param idList
     * @return
     */
    List<SysUser> selectByParamsIdList(@Param("idList") List<Long> idList);

    /**
     * 根据用户id数组查询用户
     * @param idArray
     * @return
     */
    List<SysUser> selectByIdArray(Long[] idArray);
    
    /**
     * 批量插入用户信息
     *
     * @param userList
     * @return
     */
    int insertList(List<SysUser> userList);
    
    /**
     * 通过Map更新列
     *
     * @param map
     * @return
     */
    int updateByMap(Map<String, Object> map);

    SysUser selectById(long l);
    
    int delByIdList(@Param("idList") List<Long> idList);
}