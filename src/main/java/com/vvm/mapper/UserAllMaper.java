package com.vvm.mapper;

import com.vvm.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAllMaper {
    @Select("select * from user")
    List<User> selectUserAll();

    @Select("select * from user where id=#{id}")
    User selectByPrimaryKey(@Param("id") int id);
}
