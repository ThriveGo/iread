package com.iread.account.dao;

import com.iread.account.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
    void insertUser(User user);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);
}
