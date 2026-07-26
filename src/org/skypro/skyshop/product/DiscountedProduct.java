package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0");
        }
        this.discount = discount;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент должен быть числом в диапазоне от 0 до 100 включительно");
        }
    }

    @Override
    public int getPrice() {
        return basePrice - ((basePrice * discount) / 100);
    }

    @Override
    public String toString() {
        return super.getName() + ": " + getPrice() + " (скидка " + this.discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
