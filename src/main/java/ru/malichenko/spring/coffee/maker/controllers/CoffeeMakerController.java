package ru.malichenko.spring.coffee.maker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.malichenko.spring.coffee.maker.data.Coffee;
import ru.malichenko.spring.coffee.maker.data.CoffeeMaker;
import ru.malichenko.spring.coffee.maker.services.CoffeeMakerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeMakerController {
    private CoffeeMakerService coffeeMakerService;

    public CoffeeMakerController(CoffeeMakerService coffeeMakerService) {
        this.coffeeMakerService = coffeeMakerService;
    }

    @GetMapping("/info")
    public ResponseEntity<?> info() {
        return coffeeMakerService.info();
    }

    @GetMapping("/turnOn")
    public ResponseEntity<?> turnOn() {
        return coffeeMakerService.turnOn();
    }

    @GetMapping("/milk")
    public ResponseEntity<?> fillTheBoxMilk() {
        return coffeeMakerService.fillMilkBox();
    }

    @GetMapping("/water")
    public ResponseEntity<?> fillTheBoxWater() {
        return coffeeMakerService.fillWaterBox();
    }

    @GetMapping("/coffee")
    public ResponseEntity<?> fillTheBoxCoffee(@RequestParam(defaultValue = "Arabica") String name) {
        return coffeeMakerService.fillCoffeeBox(name);
    }

    @PostMapping("/makeCoffee")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> makeCoffee(@RequestParam(defaultValue = "late") String name) {
       return coffeeMakerService.makeCoffee(name);
    }
}
