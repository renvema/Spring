package com.controller;


import com.entity.Basket;
import com.entity.Product;
import com.entity.User;
import com.service.BasketService;
import com.service.ProductService;
import com.service.UserService;
import com.utils.SaltHashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("user")
public class LoginControler {

    private UserService userService;
    private BasketService basketService;
    private ProductService productService;

    @Autowired
    public LoginControler(UserService userService,
                          BasketService basketService,
                          ProductService productService) {
        this.userService = userService;
        this.basketService = basketService;
        this.productService = productService;
    }

    @ModelAttribute("user")
    public User setUserToSession(User user) {
        return user;
    }

    @GetMapping("/")
    public String init() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @ModelAttribute("user") User user) {
        Optional<User> optUser = userService.findUserByEmail(email);
        String hashPassword = SaltHashUtil.getSHA512SecurePassword(password,
                optUser.get().getSalt());
        if (optUser.isPresent() && optUser.get().getPassword().equals(hashPassword)) {
            User getUser = optUser.get();
            user.setId(getUser.getId());
            user.setPassword(getUser.getPassword());
            user.setEmail(getUser.getEmail());
            user.setRole(getUser.getRole());
            user.setSalt(getUser.getSalt());
            if ("admin".equals(user.getRole())) {
                return "redirect:/admin/user";
            } else {
                return "redirect:/user/product";
            }
        } else {
            return "index";
        }
    }

    @GetMapping("/init")
    public String initTesUsers() {
        User test = new User("test@test.ua", "test", "admin");
        userService.addUser(test);
        User admin = new User("admin@admin.ua", "admin", "admin");
        userService.addUser(admin);
        User user = new User("user@user.ua", "user", "user");
        userService.addUser(user);
        Basket basket = new Basket(user);
        basketService.addBasket(basket);
        Product bread = new Product("bread", "white bread with garlic", 12.50);
        productService.addProduct(bread);
        Product cheese = new Product("cheese", "parmesan", 85.90);
        productService.addProduct(cheese);
        return "index";
    }
}
