package ru.malichenko.spring.coffee.maker.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.malichenko.spring.coffee.maker.Entity.LogEntity;
import ru.malichenko.spring.coffee.maker.data.CoffeeMaker;
import org.springframework.stereotype.Service;
import ru.malichenko.spring.coffee.maker.exceptions.AppError;
import ru.malichenko.spring.coffee.maker.repositories.CoffeeMakerRepository;

@Service
public class CoffeeMakerService {
    private CoffeeMakerRepository coffeeMakerRepository;
    private CoffeeMaker coffeeMaker;

    public CoffeeMakerService(CoffeeMakerRepository coffeeMakerRepository, CoffeeMaker coffeeMaker) {
        this.coffeeMakerRepository = coffeeMakerRepository;
        this.coffeeMaker = coffeeMaker;
    }

    public ResponseEntity<?> turnOn() {
        coffeeMaker.setWork(true);
        LogEntity log = new LogEntity("turnOn " + coffeeMaker.isWork(), "OK");
        coffeeMakerRepository.save(log);
        return new ResponseEntity(coffeeMaker.isWork(), HttpStatus.OK);
    }

    public ResponseEntity<?> fillWaterBox() {
        ResponseEntity<?> response = coffeeMaker.fillWaterBox();
        LogEntity log = new LogEntity("fillWaterBox " + coffeeMaker.checkTheWaterBox(), response.getStatusCode().toString());
        coffeeMakerRepository.save(log);
        return response;
    }

    public ResponseEntity<?> fillCoffeeBox(String nameCoffee) {
        ResponseEntity<?> response = coffeeMaker.fillCoffeeBox(nameCoffee);
        LogEntity log = new LogEntity("fillCoffeeBox " + coffeeMaker.checkTheCoffeeBox() + " " + coffeeMaker.getCoffeeBox().getName(), response.getStatusCode().toString());
        coffeeMakerRepository.save(log);
        return response;
    }

    public ResponseEntity<?> fillMilkBox() {
        ResponseEntity<?> response = coffeeMaker.fillMilkBox();
        LogEntity log = new LogEntity("fillMilkBox " + coffeeMaker.checkTheMilkBox(), response.getStatusCode().toString());
        coffeeMakerRepository.save(log);
        return response;
    }

    public ResponseEntity<?> makeCoffee(String name) {
        ResponseEntity<?> response = coffeeMaker.makeCoffee(name);
        LogEntity log = new LogEntity("makeCoffee " + name, response.getStatusCode().toString());
        coffeeMakerRepository.save(log);
        return response;
    }

    public ResponseEntity<?> info() {
        ResponseEntity<?> response = coffeeMaker.info();
        LogEntity log = new LogEntity("info ", response.getStatusCode().toString());
        coffeeMakerRepository.save(log);
        return response;
    }
}
