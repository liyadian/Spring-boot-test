package com.lyd.springboot.controller;

import com.lyd.springboot.Dao.impl.UserDaoImpl;
import com.lyd.springboot.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserDaoImpl userDaoImpl;

    private UserEntity user = new UserEntity();

    @RequestMapping("/ulogin")
    public String login(HttpServletRequest request, HttpSession session){
        /*
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //user = userdao.findBynameAndPassword(username, password);
        String str = "";
        if(user != null){
            session.setAttribute("userLogin", user);
            str = "hello";
        } else {
            str = "login";
        }
        return str;

         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + " password:" + password);
        if(!userDaoImpl.checkByUsername(username)){
            user = userDaoImpl.getUserByUsername(username);
            if(user.getPassword().equals(password)){
                System.out.println("login OK");
                return "login";
            }
            System.out.println("password failed");
            return "password failed";
        }
        System.out.println("user not existed");
        return "user not existed";
    }

    @RequestMapping("/uregister")
    public String register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        System.out.println("username:" + username + "  password:" + password + "  password2:" + password2);
        if(password.equals(password2) && userDaoImpl.checkByUsername(username)){
            userDaoImpl.insertUser(new UserEntity(username, password));
            System.out.println("register OK");
            return "register OK";
        }
        System.out.println("failed");
        return "fail";
        /*
        String str = "";
        if(password.equals(password2)){
            user = userdao.findByName(username);
            if(user == null){
                UserEntity user = new UserEntity(username, password);
                userdao.save(user);
                str = "login";
            } else {
                str = "register";
            }
        } else {
            str = "register";
        }
        return str;

         */

    }
}
