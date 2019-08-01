package net.liuzd.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import net.liuzd.mybatis.model.SysRole;

public interface SysRoleMapper {

    @Select({ "SELECT id,role_name roleName,enabled,create_by createBy,create_time createTime ", "FROM sys_role ",
            "WHERE id = #{id}" })
    SysRole selectById(Long id);

    SysRole selectXmlByPrimaryKey(Long id);

    @Select({
            "SELECT id,role_name roleName,enabled,create_by createBy,create_time createTime FROM sys_role WHERE id = #{id}" })
    SysRole selectByPrimaryKey(Long id);

    @Select("SELECT id,role_name roleName,enabled,create_by createBy,create_time createTime FROM sys_role")
    List<SysRole> selectAll();

    @Insert({ "INSERT INTO sys_role(id, role_name, enabled, create_by, create_time) ",
            "VALUES (#{id},#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})" })
    int insert(SysRole sysRole);

    @Insert({ "INSERT INTO sys_role(role_name, enabled, create_by, create_time) ",
            "VALUES (#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUseGeneratedKeys(SysRole sysRole);

    @Insert({ "INSERT INTO sys_role(role_name, enabled, create_by, create_time) ",
            "VALUES (#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyColumn = "id", keyProperty = "id", resultType = Long.class, before = false)
    /**
     * before = false相当于XML中的order=”AFTRE”，这是MySql数据库的配置。
     * before = true相当于XML中的order=”BEFORE”，这是Oracle数据库的配置
     * */
    int insertUseSelectKey(SysRole sysRole);

    @Update({ "UPDATE sys_role ", "SET role_name = #{roleName},enabled = #{enabled},create_by=#{createBy}, ",
            "create_time=#{createTime,jdbcType=TIMESTAMP} ", " WHERE id=#{id}" })
    int updateById(SysRole sysRole);

    @Delete("DELETE FROM sys_role WHERE id = #{id}")
    int deleteById(Long id);

}