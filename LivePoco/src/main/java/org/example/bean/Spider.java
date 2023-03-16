package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Spider {
    private Snake snake;

    @Autowired
    public Spider(Snake snake) {
        this.snake = snake;
    }

    @Override
    public String toString() {
        return "паука съела змея," + snake.toString();
    }
}
