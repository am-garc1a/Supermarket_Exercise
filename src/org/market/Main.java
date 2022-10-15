package org.market;

import org.market.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selectedOption = 0;

        SuperMarket productsStockList = new SuperMarket("Jumbo");
        ArrayList<Stock> inventory;
        String message = "";

        do {
            System.out.println("\nOptions: \n" +
                    " 1. Add product to inventory \n" +
                    " 2. Sell product of inventory \n" +
                    " 3. Restock product of inventory \n" +
                    " 4. Remove product of inventory \n" +
                    " 5. Show inventory\n" +
                    " 6. Finish work \n");
            selectedOption = scan.nextInt();

            if (selectedOption != 6) {
                switch (selectedOption) {
                    case 1:
                        System.out.println("******** Section for add product ********\t");

                        message = triggerAddProduct(productsStockList);
                        System.out.println(">>>>>>>> " + message + " <<<<<<<<");

                        break;
                    case 2:
                        System.out.println("******** Section for sell product ********\t");

                        inventory = productsStockList.getProductsStock();

                        if (inventory.size() == 0) {
                            System.out.println("～～～～～ " + emptyStockMessage() + " ～～～～～");
                        } else {
                            int productToSell = selectProduct(inventory);
                            if (productToSell >= 0 && productToSell <= inventory.size()) {
                                message = triggerSellProduct(productsStockList, (productToSell - 1));
                                System.out.println(">>>>>>>> " + message + " <<<<<<<<");
                            } else {
                                System.out.println(">>>>>>>> Coming back to principal menu <<<<<<<<");
                            }
                            continue;
                        }

                        break;
                    case 3:
                        System.out.println("******** Section for restock product ********\t");

                        inventory = productsStockList.getProductsStock();

                        if (inventory.size() == 0) {
                            System.out.println("～～～～～ " + emptyStockMessage() + " ～～～～～");
                        } else {
                            int productToRestock = selectProduct(inventory);
                            if (productToRestock >= 0 && productToRestock <= inventory.size()) {
                                message = triggerRestockProduct(productsStockList, (productToRestock - 1));
                                System.out.println(">>>>>>>> " + message + " <<<<<<<<");
                            } else {
                                System.out.println(">>>>>>>> Coming back to principal menu <<<<<<<<");
                            }
                            continue;
                        }

                        break;
                    case 4:
                        System.out.println("******** Section for remove product ********\t");

                        inventory = productsStockList.getProductsStock();

                        if (inventory.size() == 0) {
                            System.out.println("～～～～～ " + emptyStockMessage() + " ～～～～～");
                        } else {
                            int productToRemove = selectProduct(inventory);
                            if (productToRemove >= 0 && productToRemove <= inventory.size()) {
                                message = triggerRemoveProduct(productsStockList, (productToRemove - 1));
                                System.out.println(">>>>>>>> " + message + " <<<<<<<<");
                            } else {
                                System.out.println(">>>>>>>> Coming back to principal menu <<<<<<<<");
                            }
                            continue;
                        }

                        break;
                    case 5:
                        System.out.println("******** Inventory section ********\t");

                        inventory = productsStockList.getProductsStock();

                        if (inventory.size() == 0) {
                            System.out.println("～～～～～ " + emptyStockMessage() + " ～～～～～");
                        } else {
                            for (Stock item : inventory) {
                                System.out.println(item);
                            }
                        }

                        break;
                    default:
                        System.out.println("-------- Incorrect option --------\t");
                        break;
                }
            }

        } while (selectedOption != 6);
    }

    private static String emptyStockMessage() {
        return "Stock's empty";
    }

    private static String triggerAddProduct(SuperMarket productsStockList) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Type the new product");
            String productToAdd = scan.nextLine();

            System.out.println("Type the price");
            float productPrice = scan.nextFloat();

            System.out.println("Type the quantity");
            Integer productQuantity = scan.nextInt();

            Product product = new Product(productToAdd, productPrice);
            Stock prodStock = new Stock(product, productQuantity);

            productsStockList.addProductStock(prodStock);
            return "Addition succeed";
        } catch (java.util.InputMismatchException e) {
            return "Something happened";
        }
    }

    private static int selectProduct(ArrayList<Stock> inventory) {

        Scanner scan = new Scanner(System.in);
        System.out.println("\n Choose product");

        for (Stock item : inventory) {
            System.out.println("  " + item.getProduct());
        }
        System.out.println("  " + (inventory.size() + 1) + ". Go back");

        return scan.nextInt();
    }

    private static String triggerSellProduct(SuperMarket productsStockList, int productToSell) {

        Scanner scan = new Scanner(System.in);

        String message = "";

        System.out.println("Type the amount you want to sell");
        int quantityToSell = scan.nextInt();
        message = productsStockList.sellProductStock(productToSell, quantityToSell)
                ? "Sale succeed"
                : "Check stock product";

        return message;
    }

    private static String triggerRestockProduct(SuperMarket productsStockList, int productToRestock) {

        Scanner scan = new Scanner(System.in);

        String message = "";

        System.out.println("Type the amount you want to restock");
        int quantityToRestock = scan.nextInt();
        message = productsStockList.restockProductStock(productToRestock, quantityToRestock)
                ? "Successful restock"
                : "Try again please";

        return message;
    }

    private static String triggerRemoveProduct(SuperMarket productsStockList, int productToRemove) {
        productsStockList.removeProductStock(productToRemove);
        return "Removal succeed";
    }

}