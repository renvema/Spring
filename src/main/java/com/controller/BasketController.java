package com.controller;

import com.entity.Basket;
import com.entity.Product;
import com.entity.User;
import com.service.BasketService;
import com.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@Controller
@RequestMapping("/user/product")
public class BasketController {

    private BasketService basketService;
    private ProductService productService;

    @Autowired
    public BasketController(BasketService basketService,
                            ProductService productService) {
        this.basketService = basketService;
        this.productService = productService;
    }

    @GetMapping
    public String byProduct(@SessionAttribute("user") User user,
                            Model model) {
        Optional<Basket> optionalBasket = basketService.getBasketByUser(user);
        optionalBasket.ifPresent(basket ->
                model.addAttribute("size", basketService.size(basket)));
        model.addAttribute("products", productService.getAll());
        return "products_user";
    }

    @GetMapping("/buy/{id}")
    public String addProductInBasket(@PathVariable("id") Long id,
                                     @AuthenticationPrincipal User user) {
        Product product = null;
        Optional<Product> optionalProduct = productService.getProductsById(id);
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
        }
        Basket basket = null;
        Optional<Basket> optionalBasket = basketService.getBasketByUser(user);
        if (optionalBasket.isPresent()) {
            basket = optionalBasket.get();
        }
        basketService.addProductToBasket(basket, product);
        return "redirect:/user/product";
    }
}
