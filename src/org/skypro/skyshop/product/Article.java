package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable {

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String searchType() {
        return "ARTICLE";
    }

    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return this.name + "\n" + this.text;

    }
}
