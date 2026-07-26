package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0");
        }
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.getName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
