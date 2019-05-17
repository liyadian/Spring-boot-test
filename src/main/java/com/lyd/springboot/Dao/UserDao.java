package com.lyd.springboot.Dao;

import com.lyd.springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
/*
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 */

public interface UserDao {
    /*

    @Query("select s from userinfo where s.username=?1 and s.password=?2")
    public UserEntity findBynameAndPassword(String username, String password);

    @Query("select s from userinfo where s.username=?")
    public UserEntity findByName(String username);

     */

    public Integer insertUser(UserEntity userEntity);
    public UserEntity getUserByUsername(String username);
    public Boolean checkByUsername(String username);
    public Integer getUserCount();
    public Integer newUpdateUser(UserEntity userEntity);
}
