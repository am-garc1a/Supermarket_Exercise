package org.market.model;

public class Stock {
    // attributes
    private Product product;
    private Integer quantity;

    // constructor
    public Stock(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // methods
    public Product getProduct() {
        return product;
    }

    public boolean sellProduct(Integer quantityToSell) {
        if (quantityToSell <= quantity) {
            quantity -= quantityToSell;
            return true;
        }
        return false;
    }

    public boolean restockProduct(Integer quantityToRestock) {
        if (quantityToRestock > 0) {
            quantity += quantityToRestock;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return product + ", Quantity = " + quantity;
    }
}