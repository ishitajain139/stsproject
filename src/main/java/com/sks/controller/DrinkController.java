package com.sks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sks.entity.Drink;
import com.sks.repository.DrinkRepository;

@RestController
@RequestMapping("/api/drink")
public class DrinkController {
	
	
    @Autowired
    private DrinkRepository drinkRepo;

    @GetMapping
    public Iterable<Drink> findAll() {
        return drinkRepo.findAll();
    }

    @GetMapping("/name/{drinkName}")
    public List<Drink> findByName(@PathVariable String drinkName) {
        return drinkRepo.findByName(drinkName);
    }

    @GetMapping("/type/{drinkType}")
    public List<Drink> findByType(@PathVariable String drinkType) {
        return drinkRepo.findByType(drinkType);
    }
    
    @GetMapping("/{id}")
    public Drink findOne(@PathVariable Integer id) {
        Optional<Drink> drinkOptional = drinkRepo.findById(id);
        return drinkOptional.orElse(null); 
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Drink create(@RequestBody Drink drink) {
        return drinkRepo.save(drink);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        drinkRepo.findById(id);
        drinkRepo.deleteById(id);
    }

    @PutMapping("update/{id}")
    public Drink updateDrink(@RequestBody Drink drink, @PathVariable Integer id) {
        drinkRepo.findById(id);
        return drinkRepo.save(drink);
    }

}

