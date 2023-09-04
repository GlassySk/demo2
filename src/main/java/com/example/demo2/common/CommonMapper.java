package com.example.demo2.common;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;

/**
 * @author HJL
 */
public interface CommonMapper<T> extends Mapper<T> {
    /**
     * 新增实体，返回后携带生成的主键
     * @param o 实体
     * @return 新增后的实体
     */
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Override
    int insert(T o);
}
