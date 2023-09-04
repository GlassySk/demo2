package com.example.demo2.dao;

import com.example.demo2.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface UserMapper {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserInfo(int id);
    /**
     * 新增用户
     * @param user
     * @return
     */
    int save (User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update (User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById (int id);

    /**
     * 查询所有用户信息
     * @return
     */

    List<User> selectAll ();
    @Select("SELECT * FROM user WHERE id>2")
    User k();

    @Select("<script>" +
            "SELECT * FROM user" +
            "<where>" +
            "<if test = 'realName != null'>" +
            " realName = #{id} " +
            "</if>" +
            "</where>" +
            " order by passWord desc " +
            "</script>")
    Page<User> userpage(String id);
}