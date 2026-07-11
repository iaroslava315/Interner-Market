package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable.Searchable;

public abstract class Product implements Searchable {

    private final String name;


    public Product(String name) {
        this.name = name;
    }

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
