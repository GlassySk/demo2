package com.example.demo2.common;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HJL
 */
@Service
public abstract class BaseCommonServiceImpl<T> implements CommonService<T> {

    /**
     * 获取mapper
     * @return CommonMapper<T>
     */
    protected abstract CommonMapper<T> getMapper();

    /**
     * 通用查询
     * @param params 参数
     * @return List<T>
     */
    public abstract List<T> findAll(Map<String, Object> params);

    @Override
    public T getByKey(Object key) {
        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public T getOne(T entity) {
        return getMapper().selectOne(entity);
    }

    @Override
    public int insert(T entity) {
        return getMapper().insert(entity);
    }

    @Override
    public int deleteByKey(Object key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public int update(T entity) {
        return getMapper().updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        return getMapper().updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> all() {
        return getMapper().selectAll();
    }

    @Override
    public List<T> selectPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return getMapper().selectAll();
    }

    @Override
    public List<T> selectPage(int pageNum, int pageSize, T entity) {
        PageHelper.startPage(pageNum, pageSize);
        return getMapper().select(entity);
    }


    public Boolean isExist(Object key) {
        return getMapper().existsWithPrimaryKey(key);
    }

}