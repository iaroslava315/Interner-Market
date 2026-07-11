package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {

        Product p1 = new SimpleProduct("Платье", 200);
        Product p2 = new SimpleProduct("Сандали", 500);
        Product p3 = new DiscountedProduct("Панама", 100, 5);
        Product p4 = new FixPriceProduct("Шляпа");
        Product p5 = new DiscountedProduct("Блуза", 300, 15);
        Product p6 = new FixPriceProduct("Тапочки");


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
        b1.checkMethodCheckProduct("Панама");

        System.out.println("Поиск товара, которого нет в корзине:");
        b1.checkMethodCheckProduct("Брюки");

        System.out.println("Очистка корзины. Печать содержимого пустой корзины:");
        b1.cleanBasket();
        b1.showBasket();

        System.out.println("Получение стоимости пустой корзины: " + b1.countSum());

        System.out.println("Поиск товара по имени в пустой корзине: ");
        b1.checkMethodCheckProduct("Блуза");

    }
}
