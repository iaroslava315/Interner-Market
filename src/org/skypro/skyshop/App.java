package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main() {

        Product p1 = new Product("Платье", 200);
        Product p2 = new Product("Сандали", 500);
        Product p3 = new Product("Шарф", 200);
        Product p4 = new Product("Пальто", 400);
        Product p5 = new Product("Блуза", 300);
        Product p6 = new Product("Тапочки", 100);


        ProductBasket b1 = new ProductBasket();

        System.out.println("Добавление продукта в корзину:");
        b1.addProduct(p1);
        b1.addProduct(p2);
        b1.addProduct(p3);
        b1.addProduct(p4);
        b1.showBasket();

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места:");
        b1.addProduct(p5);
        b1.addProduct(p6);
        b1.showBasket();

        System.out.println("Получение стоимости корзины с несколькими товарами: " + b1.countSum());

        System.out.println("Поиск товара, который есть в корзине:");
        if (b1.checkProduct("Блуза")) {
            System.out.println("В корзине есть такой продукт.");
        } else {
            System.out.println("Такого продукта в корзине нет.");
        }

        System.out.println("Поиск товара, которого нет в корзине:");
        if (b1.checkProduct("Брюки")) {
            System.out.println("В корзине есть такой продукт.");
        } else {
            System.out.println("Такого продукта в корзине нет.");
        }

        System.out.println("Очистка корзины. Печать содержимого пустой корзины:");
        b1.cleanBasket();
        b1.showBasket();

        System.out.println("Получение стоимости пустой корзины: " + b1.countSum());

        System.out.println("Поиск товара по имени в пустой корзине: ");
        if (b1.checkProduct("Блуза")) {
            System.out.println("В корзине есть такой продукт.");
        } else {
            System.out.println("Такого продукта в корзине нет.");
        }








    }
}
