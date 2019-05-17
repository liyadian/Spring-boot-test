package com.lyd.springboot;

import com.lyd.springboot.Dao.UserDao;
import com.lyd.springboot.entity.UserEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    /**
     *
     */
    @Autowired
    private UserDao userdao;

/*
    @Test
    @Ignore
    public void testInserUser(){
        UserEntity user = new UserEntity();
        user.setUsername("root");
        user.setPassword("123456");
        user.setIsAllowedGrant(1);
        user.setIsAllowedUp(1);
        user.setIsAllowedDele(1);
        user.setIsAllowedCheck(1);

        int result = this.userdao.insertUser(user);
        System.out.println(result);
    }

 */


}
