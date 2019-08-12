package com.controller;

import com.entity.Basket;
import com.entity.Code;
import com.entity.Order;
import com.entity.User;
import com.service.BasketService;
import com.service.CodeService;
import com.service.MailService;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/user/order")
public class OrderController {

    private MailService mailService;
    private OrderService orderService;
    private CodeService codeService;
    private BasketService basketService;

    @Autowired
    public OrderController(MailService mailService, OrderService orderService,
                           CodeService codeService, BasketService basketService) {
        this.mailService = mailService;
        this.orderService = orderService;
        this.codeService = codeService;
        this.basketService = basketService;
    }

    @GetMapping
    public ModelAndView showPaymentPage() {
        return new ModelAndView("order", "order", new Order());
    }

    @PostMapping
    public String createOrder(@ModelAttribute("order") Order order,
                              @SessionAttribute("user") User user,
                              ModelMap model) {
        if (order.getName().isEmpty() || order.getSurname().isEmpty() || order.getCity().isEmpty() ||
                order.getAddress().isEmpty() || order.getPhone().isEmpty()) {
            model.addAttribute("error", "Empty fields!");
        } else {

            codeService.add(new Code(user));
            Code code = null;
            Optional<Code> optionalCode = codeService.getCodeForUser(user);
            if (optionalCode.isPresent()) {
                code = optionalCode.get();
            }
            Basket basket = null;
            Optional<Basket> optionalBasket = basketService.getBasketByUser(user);
            if (optionalBasket.isPresent()) {
                basket = optionalBasket.get();
            }
            order.setUser(user);
            order.setBasket(basket);
            order.setCode(code);
            orderService.add(order);
            mailService.sendConfirmCode(order);
        }
        return "redirect:/user/payment/confirm";
    }


    @GetMapping("/confirm")
    public String showConfirmOrderPage() {
        return "confirm";
    }

    @PostMapping("/confirm")
    public String confirmOrder(@RequestParam("confirm") String confirm,
                               @SessionAttribute("user") User user,
                               Model model) {
        Optional<Order> optionalOrder = orderService.getOrder(user);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            if (order.getCode().getCode().equals(confirm)) {
                Basket basket = new Basket(order.getUser());
                basketService.addBasket(basket);
                model.addAttribute("message", "Your buying is successful.");
            } else {
                model.addAttribute("message", "The code is wrong. Try again");
            }
        }
        return "payment_confirm";
    }
}
