package org.example.entity;

public class Tyre {

    private final double price;
    private final String brand;

    public Tyre(double price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    // Getters

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Tyre [brand=" + brand + ", price=" + price + "]";
    }
}