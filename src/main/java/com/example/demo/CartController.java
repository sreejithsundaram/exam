package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

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
    @DeleteMapping("/")
    void deleteAll(){
        cartRepository.deleteAll(); 
    }
    @PostMapping("/") 
    cart save(@RequestBody cart cart_){
        return cartRepository.save(cart_);
    }
}
