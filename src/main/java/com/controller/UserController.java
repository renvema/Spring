package com.controller;

import com.entity.User;
import com.service.BasketService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    private UserService userService;
    private BasketService basketService;

    @Autowired
    public UserController(UserService userService, BasketService basketService) {
        this.userService = userService;
        this.basketService = basketService;
    }

    @GetMapping
    public String allUsers(Model model) {

        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserPage(@PathVariable("id") Long id, Model model) {
        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
        }
        return "edit_user";
    }


}
