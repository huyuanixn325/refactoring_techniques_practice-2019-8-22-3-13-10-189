package com.tws.refactoring.extract_variable;

public class PriceCalculator {

    public static final int maxPrice = 500;
    public static final double maxPriceRatio = 0.05;
    public static final double minPriceRatio = 0.1;
    public static final double minPrice = 100.0;

    double getPrice(int quantity, int itemPrice) {
        // Price consists of: base price - discount + shipping cost
        return getaDouble(quantity, itemPrice);

    }

    private double getaDouble(int quantity, int itemPrice) {
        return quantity * itemPrice -
                getaDouble(itemPrice, getMax(quantity), maxPriceRatio) +
                getMin(quantity, itemPrice);
    }

    private double getaDouble(int itemPrice, int max, double maxPriceRatio) {
        return max * itemPrice * maxPriceRatio;
    }

    private double getMin(int quantity, int itemPrice) {
        return Math.min(getaDouble(itemPrice, quantity, minPriceRatio), minPrice);
    }

    private int getMax(int quantity) {
        return Math.max(0, quantity - maxPrice);
    }
}
