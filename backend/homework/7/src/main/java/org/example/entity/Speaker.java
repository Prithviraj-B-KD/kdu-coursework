package org.example.entity;

public class Speaker {

    private final double price;
    private final String brand;

    public Speaker(double price, String brand) {
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
        return "Speaker [brand=" + brand + ", price=" + price + "]";
    }
}