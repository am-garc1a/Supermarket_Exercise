package org.market.model;

import java.util.ArrayList;

public class SuperMarket {
    // attributes
    private ArrayList<Stock> productsStock;
    private String superMarketName;

    // constructor
    public SuperMarket(String superMarketName) {
        this.productsStock = new ArrayList<>();
        this.superMarketName = superMarketName;
    }

    // methods
    public void addProductStock(Stock productStock) {
        this.productsStock.add(productStock);
    }

    public boolean sellProductStock(int productToSell, int quantityToSell) {
        boolean correctSale = productsStock.get(productToSell).sellProduct(quantityToSell);
        if (correctSale) {
            this.productsStock.set(productToSell, productsStock.get(productToSell));
            return true;
        }
        return false;
    }

    public boolean restockProductStock(int productToRestock, int quantityToRestock) {
        boolean correctRestock = productsStock.get(productToRestock).restockProduct(quantityToRestock);
        if (correctRestock) {
            this.productsStock.set(productToRestock, productsStock.get(productToRestock));
            return true;
        }
        return false;
    }

    public void removeProductStock(int productToRemove) {
        this.productsStock.remove(productToRemove);
    }

    public ArrayList<Stock> getProductsStock() {
        return productsStock;
    }

}