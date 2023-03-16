package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Аннотация Component сказала спрингу, что класс, который ей аннотируем, это бин
@Component
public class Bug {
    private final Bird bird;

    // Аннотация Autowired попросила Spring в поле, которое она аннотирует, подставить значение (инжектнуть)
    @Autowired
    public Bug(Bird bird) {
        this.bird = bird;
    }



    @Override
    public String toString() {
        return "жучка съела птичка," + bird.toString();
    }
}
