package ru.malichenko.spring.coffee.maker.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Coffee {
    private String name;
}
