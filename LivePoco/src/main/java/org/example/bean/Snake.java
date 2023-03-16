package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Snake {
    private Mangust mangust;

    @Autowired
    public Snake(Mangust mangust) {
        this.mangust = mangust;
    }

    @Override
    public String toString() {
        return "змею съел мангуст," + mangust;
    }
}
