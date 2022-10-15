package org.market.model;

public class Product {
    // attributes
    private Integer id;
    private String name;
    private float price;
    private static int countId;

    // constructor
    public Product(String name, float price) {
        this.id = ++countId;
        this.name = name;
        this.price = price;
    }

    // methods
    @Override
    public String toString() {
        return id + ". Name = " + name + ", Price = $" + price;
    }
}

/*

    @Override
    public String toString() {
        return "{" + id + ", Name = " + name + ", Price = " + price + "}";
    }

*/