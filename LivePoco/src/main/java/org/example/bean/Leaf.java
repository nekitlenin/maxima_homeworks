package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Leaf {
    private Bug bug;
    /**
     * Инжект бина по конструктору
     */
    @Autowired
    public Leaf(Bug bug) {
        this.bug = bug;
    }

    @Override
    public String toString() {
        return "Листик съел жучок," + bug.toString();
    }
}
