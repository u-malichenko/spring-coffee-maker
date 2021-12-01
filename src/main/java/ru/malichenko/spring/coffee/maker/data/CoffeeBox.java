package ru.malichenko.spring.coffee.maker.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Data
@NoArgsConstructor
public class CoffeeBox {

    private boolean isFull;
    private String name;

    public boolean checkBox() {
        return isFull;
    }

    public CoffeeBox fillBox(String name) {
        this.name=name;
        this.isFull = true;
        return  this;
    }
}
