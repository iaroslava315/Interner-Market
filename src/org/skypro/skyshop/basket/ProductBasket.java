package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    List<Product> basket = new LinkedList<>();
    private int totalPrice = 0;

    public void addProduct(Product product) {
        basket.add(product);
        totalPrice += product.getPrice();
    }

    public List<Product> deleteProductByName(String name) {
        List<Product> deletedProducts = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                deletedProducts.add(product);
                iterator.remove();
                totalPrice -= product.getPrice();
            }
        }
        return deletedProducts;
    }

    public int countSum() {
        int basketPrice = 0;
        for (Product element : basket) {
            if (element != null) {
                basketPrice = basketPrice + element.getPrice();
            }
        }
        return basketPrice;
    }

    public int countSpecialProducts() {
        int count = 0;
        for (Product element : basket) {
            if (element != null && element.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public void showBasket() {
        int count = 0;
        for (Product element : basket) {
            if (element != null) {
                System.out.println(element.toString());
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
        for (Product element : basket) {
            if (element != null) {
                isEmpty = false;
                if (element.getName().equals(name)) {
                    return true;
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



