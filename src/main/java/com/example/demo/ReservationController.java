package com.example.demo;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationRepository repository;

    public ReservationController() {

    }

    @GetMapping("/")
    List<Reservation> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Reservation getById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    Reservation insert(@RequestBody Reservation reservation) {
        return repository.insert(reservation);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    Reservation update(@RequestBody Reservation reservation, @PathVariable String id) {
            reservation.id = id;
            return repository.save(reservation);
    }
}
