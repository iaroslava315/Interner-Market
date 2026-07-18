package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] basket = new Product[5];
    private int totalPrice = 0;

    public void addProduct(Product product) {
        boolean added = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                added = true;
                totalPrice += product.getPrice();
                break;
            }
        }
        if (!added) {
            System.out.println("Невозможно добавить продукт");
        }
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
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                totalPrice -= basket[i].getPrice();
                basket[i] = null;
            }
        }
    }


}



