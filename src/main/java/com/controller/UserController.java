package com.controller;

import com.entity.Basket;
import com.entity.User;
import com.service.BasketService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

        model.addAttribute("allUsers", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/add")
    public ModelAndView addUserPage() {
        return new ModelAndView("add_user", "user", new User());
    }

    @PostMapping("/add")
    public ModelAndView addUser(@ModelAttribute("user") User user,
                                @RequestParam("repeatPassword") String repeatPassword,
                                ModelMap model) {
        String email = user.getEmail();
        String password = user.getPassword();
        String role = user.getRole();
        if (email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            model.addAttribute("error", "Empty fields!");
        } else if (password.equals(repeatPassword)) {
            userService.addUser(user);
            Basket basket = new Basket(userService.findUserByEmail(email).get());
            basketService.addBasket(basket);
            return new ModelAndView("redirect:/admin/user");
        } else {
            model.addAttribute("error", "You passwords not equals");
        }
        return new ModelAndView("addUser", model);
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
        }
        return "edit_user";
    }

    @PostMapping("/edit")
    public String saveEditUser(@ModelAttribute("user") User user, ModelMap model) {
        String email = user.getEmail();
        String password = user.getPassword();
        String role = user.getRole();
        if (email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            model.addAttribute("error", "Empty fields!");
            model.addAttribute("user", user);
        } else {
            userService.updateUser(user);
            return "redirect:/admin/user";
        }
        return "edit_user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }
}
