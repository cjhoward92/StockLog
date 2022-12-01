package com.stocklog.stocklog.data;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectUserById(long id);

    long insertUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);
}
