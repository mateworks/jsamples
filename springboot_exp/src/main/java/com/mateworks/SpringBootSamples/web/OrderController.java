package com.mateworks.SpringBootSamples.web;

import com.mateworks.SpringBootSamples.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by James Cheung on 2017/6/30.
 */
@RestController
@RequestMapping(value="/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @RequestMapping("/")
    public void createOrder(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map){
        try {
            this.orderService.createOrder(0,0,0);
            response.getWriter().write("Hi!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
