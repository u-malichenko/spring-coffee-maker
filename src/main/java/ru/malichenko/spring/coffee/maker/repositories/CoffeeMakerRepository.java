package ru.malichenko.spring.coffee.maker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.malichenko.spring.coffee.maker.Entity.LogEntity;

@Repository
public interface CoffeeMakerRepository extends JpaRepository<LogEntity, Long> {
}
