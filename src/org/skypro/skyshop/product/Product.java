package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable {

    private final String name;


    public Product(String name) {
        this.name = name;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract String toString();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return this.name;
    }

    @Override
    public String searchType() {
        return "PRODUCT";
    }
}
