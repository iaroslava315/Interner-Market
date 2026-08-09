package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    Map<String, List<Product>> basket = new HashMap<>();
    private int totalPrice = 0;

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        totalPrice += product.getPrice();
    }

    public List<Product> deleteProductByName(String name) {
        List<Product> deletedProducts = basket.remove(name);
        if (deletedProducts != null) {
            for (Product product : deletedProducts) {
                totalPrice -= product.getPrice();
            }
        }
        if (deletedProducts == null) {
            return Collections.emptyList();
        } else {
            return deletedProducts;
        }
    }

    public int countSum() {
        int basketPrice = 0;
        for (List<Product> productList : basket.values()) {
            for (Product element : productList) {
                if (element != null) {
                    basketPrice += element.getPrice();
                }
            }
        }
        return basketPrice;
    }

    public int countSpecialProducts() {
        int count = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void showBasket() {
        int count = 0;
        for (List<Product> productList : basket.values()) {
            if (productList != null) {
                for (Product product : productList) {
                    System.out.println(product);
                }
                count++;
            }
        }
        if (count == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + totalPrice);
            System.out.println("Специальных товаров: " + countSpecialProducts());
        }
    }

    public boolean checkProduct(String name) {
        boolean isEmpty = true;
        for (List<Product> productList : basket.values()) {
            if (productList != null) {
                isEmpty = false;
                for (Product product : productList) {
                    if (product.getName().equals(name)) {
                        return true;
                    }
                }
            }
        }
        if (isEmpty) {
            System.out.println("Корзина пуста.");
        }
        return false;
    }

    public void checkMethodCheckProduct(String productName) {
        if (this.checkProduct(productName)) {
            System.out.println("В корзине есть такой продукт.");
        } else {
            System.out.println("Такого продукта в корзине нет.");
        }
    }



    public void cleanBasket() {
        basket.clear();
        totalPrice = 0;
    }


}



