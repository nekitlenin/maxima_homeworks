package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bird {
    private Spider spider;

    public Bird(Spider spider) {
        this.spider = spider;
    }

    /**
     * Инжект бина по сеттеру
     */
    @Autowired
    public void setSpider(Spider spider) {
        this.spider = spider;
    }

    @Override
    public String toString() {
        return "птичку съел паук," + spider;
    }
}
