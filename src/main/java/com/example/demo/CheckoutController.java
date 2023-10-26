package com.example.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutRepository checkoutRepository;

    @PostMapping("/")
    List<Checkout> checkout(@RequestBody ArrayList<Checkout> items){
        return checkoutRepository.saveAll(items);
    }
    
}
