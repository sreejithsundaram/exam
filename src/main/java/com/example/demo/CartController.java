package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    public CartController() {}

    @GetMapping("/")
    List<cart> getAll(){
        return cartRepository.findAll();
    }
}
