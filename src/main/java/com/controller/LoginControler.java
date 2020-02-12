package com.controller;


import com.entity.Basket;
import com.entity.Product;
import com.entity.User;
import com.service.BasketService;
import com.service.ProductService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.PostConstruct;

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

    @GetMapping("/")
    public String login(@AuthenticationPrincipal User user) {
        if (user == null) {
            return "redirect:/login";
        } else if ("ROLE_ADMIN".equals(user.getRole())) {
            return "redirect:/admin/user";
        } else {
            return "redirect:/user/product";
        }
    }

    @PostConstruct
    public String initTestUsers() {
        User test = new User("test@test.ua", "test", "ROLE_ADMIN");
        userService.addUser(test);
        User admin = new User("admin@admin.ua", "admin", "ROLE_ADMIN");
        userService.addUser(admin);
        User user = new User("user@user.ua", "user", "ROLE_USER");
        userService.addUser(user);
        Basket basket = new Basket(user);
        basketService.addBasket(basket);
        Product bread = new Product("bread", "white bread with garlic", 12.50);
        productService.addProduct(bread);
        Product cheese = new Product("cheese", "parmesan", 85.80);
        productService.addProduct(cheese);
        return "index";
    }
}
