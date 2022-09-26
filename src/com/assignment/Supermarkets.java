package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Supermarkets {

    private List<Supermarket> supermarkets;

    public Supermarkets() {
        supermarkets = new ArrayList<>();
    }

    public List<Supermarket> getSupermarkets() {
        return supermarkets;
    }

    public void setSupermarkets(List<Supermarket> supermarkets) {
        this.supermarkets = supermarkets;
    }
}
