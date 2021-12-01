package ru.malichenko.spring.coffee.maker.data;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.malichenko.spring.coffee.maker.exceptions.AppError;

import javax.annotation.PostConstruct;

@Component
@Scope("singleton")
@Data
@Slf4j
public class CoffeeMaker {
    private WaterBox waterBox;
    private CoffeeBox coffeeBox;
    private MilkBox milkBox;
    private boolean isWork;

    public CoffeeMaker(WaterBox waterBox, CoffeeBox coffeeBox, MilkBox milkBox) {
        this.waterBox = waterBox;
        this.coffeeBox = coffeeBox;
        this.milkBox = milkBox;
    }

    @PostConstruct
    public void init() {
        isWork = false;
    }

    public boolean isWork() {
        return isWork;
    }

    public boolean checkTheMilkBox() {
        return milkBox.checkBox();
    }

    public ResponseEntity<?> fillMilkBox() {
        return new ResponseEntity<>(this.milkBox.fillBox(), HttpStatus.OK);
    }

    public boolean checkTheWaterBox() {
        return waterBox.checkBox();
    }

    public ResponseEntity<?> fillWaterBox() {
        return new ResponseEntity<>(this.waterBox.fillBox(), HttpStatus.OK);
    }

    public boolean checkTheCoffeeBox() {
        return coffeeBox.checkBox();
    }

    public ResponseEntity<?> fillCoffeeBox(String name) {
        return new ResponseEntity<>(this.coffeeBox.fillBox(name), HttpStatus.OK);
    }

    public ResponseEntity<?> info() {
        return new ResponseEntity<>(this, HttpStatus.OK);
    }

    public ResponseEntity<?> makeCoffee(String name) {
        if (!waterBox.checkBox()) {
            log.error("waterBox empty ");
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "waterBox empty "), HttpStatus.FORBIDDEN);
        }else if (!coffeeBox.checkBox()){
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "coffeeBox empty "), HttpStatus.FORBIDDEN);
        }else if (!milkBox.checkBox()){
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "milkBox empty "), HttpStatus.FORBIDDEN);
        }else if (!isWork){
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "turn ON  CoffeeMaker"), HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity(doWork(name), HttpStatus.CREATED);
    }

    private Coffee doWork (String name){
        Coffee coffee = new Coffee();
        coffee.setName(name+" from "+coffeeBox.getName());
        coffeeBox.setFull(false);
        waterBox.setFull(false);
        milkBox.setFull(false);
        isWork=false;
        return coffee;
    }
}
