package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mangust {
    private Leopard leopard;

    @Autowired
    public Mangust(Leopard leopard) {
        this.leopard = leopard;
    }

    @Override
    public String toString() {
        return "мангуста съел леопард," + leopard.toString();
    }
}
