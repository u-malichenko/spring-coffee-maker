package ru.malichenko.spring.coffee.maker.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Data
@NoArgsConstructor
public class MilkBox {

    private boolean isFull;

    public boolean checkBox() {
        return isFull;
    }

    public MilkBox fillBox() {
        isFull = true;
        return this;
    }
}
