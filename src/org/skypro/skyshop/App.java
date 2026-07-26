package org.skypro.skyshop;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.searchable.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;


public class App {

    public static void main(String[] args) {


        try {
            Product p15 = new SimpleProduct(" ", 200);
        } catch (IllegalArgumentException e) {
            System.out.println("Возникла ошибка: " + e.getMessage());
        }

        try {
            Product p22 = new SimpleProduct("Сандали", -500);
        } catch (IllegalArgumentException b) {
            System.out.println("Возникла ошибка: " + b.getMessage());
        }

        try {
            Product p33 = new DiscountedProduct("Панама", 100, 120);
        } catch (IllegalArgumentException c) {
            System.out.println("Возникла ошибка: " + c.getMessage());
        }

        Product p1 = new SimpleProduct("Платье ", 200);
        Product p2 = new SimpleProduct("Сандали", 500);
        Product p3 = new DiscountedProduct("Панама", 100, 5);
        Product p4 = new FixPriceProduct("Шляпа");
        Product p5 = new DiscountedProduct("Блуза", 300, 15);
        Product p6 = new FixPriceProduct("Тапочки");
        Article a1 = new Article("Платье", "Черное, шелковое, миди");
        Article a2 = new Article("Шляпа", "Летняя, соломенная, с большими бортами");

        SearchEngine search = new SearchEngine(10);
        search.add(p1);
        search.add(p2);
        search.add(p3);
        search.add(p4);
        search.add(p5);
        search.add(p6);
        search.add(a1);
        search.add(a2);

        System.out.println("Демонстрация нового метода поиска");

        try {
            Searchable result = search.searchBestResult("Пла");
            System.out.println("Результаты поиска для 'Пла': " + result);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable result = search.searchBestResult("Хлеб");
            System.out.println("Результаты поиска для 'Хлеб': " + result);
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }


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


        System.out.println("Демонстрация поиска");
        Searchable[] results = search.search("Платье");
        System.out.println("Результаты поиска для 'Платье'");
        for (Searchable element : results) {
            if (element != null) {
                System.out.println(element.getStringRepresentation());
            }
        }

        results = search.search("Шляпа");
        System.out.println("Результаты поиска для 'Шляпа'");
        for (Searchable e : results) {
            if (e != null) {
                System.out.println(e.getStringRepresentation());
            }
        }


    }
}
