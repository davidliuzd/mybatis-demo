package net.liuzd.mybatis.mapper;

import net.liuzd.mybatis.model.Country;

import java.util.List;

public interface CountryMapper {
    /**
     * 查询全部用户
     *
     * @return
     */
    List<Country> selectAll();
}
