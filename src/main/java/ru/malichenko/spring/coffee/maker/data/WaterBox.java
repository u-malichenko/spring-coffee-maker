package ru.malichenko.spring.coffee.maker.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Data
@NoArgsConstructor
public class WaterBox {

    private boolean isFull;

    public boolean checkBox() {
        return isFull;
    }

    public WaterBox fillBox() {
        isFull = true;
        return  this;
    }
}
