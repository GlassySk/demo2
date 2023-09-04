package com.example.demo2.common;

import java.util.List;

/**
 * @author HJL
 */
public interface CommonService<T> {
    /**
     * 获取详情
     * @param key 关键字
     * @return 对象实体
     */
    T getByKey(Object key);

    /**
     * 获取详情
     * @param entity 符合条件的对象
     * @return 对象实体
     */
    T getOne(T entity);

    /**
     * 新增
     * @param entity 实体
     * @return 数量
     */
    int insert(T entity);

    /**
     * 根据关键字删除
     * @param key 关键字
     * @return 删除数量
     */
    int deleteByKey(Object key);

    /**
     * 更新
     * @param entity 实体
     * @return 更新数量
     */
    int update(T entity);

    /**
     * 非空更新
     * @param entity 实体
     * @return 更新数量
     */
    int updateNotNull(T entity);

    /**
     * 获取全部
     * @return list
     */
    List<T> all();

    /**
     * 分页查询
     * @param pageNum 页码
     * @param pageSize 数量
     * @return List<T>
     */
    List<T> selectPage(int pageNum, int pageSize);

    /**
     * 根据条件分页查询
     * @param pageNum 页码
     * @param pageSize 数量
     * @param entity 查询条件
     * @return List<T>
     */
    List<T> selectPage(int pageNum, int pageSize, T entity);

}