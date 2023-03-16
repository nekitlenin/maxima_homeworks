package org.example.config;

import org.example.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project: LivePoco
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 12.03.2023 18:11 |
 * Created with IntelliJ IDEA
 */
@Configuration
public class BeanConfig {
    @Bean
    public Leopard leopard() {
        return new Leopard();
    }

    @Bean
    public Mangust mangust(Leopard leopard) {
        return new Mangust(leopard);
    }

    @Bean
    public Snake snake(Mangust mangust) {
        return new Snake(mangust);
    }

    @Bean
    public Spider spider(Snake snake) {
        return new Spider(snake);
    }

    @Bean
    public Bird bird(Spider spider) {
        return new Bird(spider);
    }

    @Bean
    public Bug bug(Bird bird) {
        return new Bug(bird);
    }

    @Bean
    public Leaf leaf(Bug bug) {
        return new Leaf(bug);
    }
}
