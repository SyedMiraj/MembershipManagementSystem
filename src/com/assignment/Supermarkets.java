package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Supermarkets {

    private List<Supermarket> supermarkets;

    public Supermarkets() {
        supermarkets = new ArrayList<>();
        supermarkets.add(new Supermarket("John Smith", "john.smith@uts.com", "user222"));
        supermarkets.add(new Supermarket("Jane Tyler", "jane.tyler@uts.com", "super123"));
    }

    public List<Supermarket> getSupermarkets() {
        return supermarkets;
    }

    public void setSupermarkets(List<Supermarket> supermarkets) {
        this.supermarkets = supermarkets;
    }
}
