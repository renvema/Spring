package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller("/admin")
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("message", "Hello Spring MVC!");

        return "index";
    }

//    @RequestMapping(path = {"/init"}, method = RequestMethod.GET)
//    public String initTesUsers(Model model) {
//        User test = new User("test@test.ua", "test", "admin");
//        userService.addUser(test);
//        User admin = new User("admin@admin.ua","admin", "admin");
//        userService.addUser(admin);
//        User user = new User("user@user.ua", "user", "user");
//        userService.addUser(user);
//
//        model.addAttribute("message", "Hello Spring MVC!");
//
//        return "index";
//    }

//    @RequestMapping(path = {"/users"}, method = RequestMethod.GET)
//    public String allUsers(Model model) {
//
//        model.addAttribute("message", "Hello Spring MVC!");
//        model.addAttribute("users", userService.getAllUsers());
//
//        return "users";
//    }
}
