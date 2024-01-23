package org.example.entity;

public class Vehicle {

    private final Tyre tyre;
    private final Speaker speaker;
    private final double price;
    private final String factoryId;

    public Vehicle(Tyre tyre, Speaker speaker, double price, String factoryId) {
        this.tyre = tyre;
        this.speaker = speaker;
        this.price = price;
        this.factoryId = factoryId;
    }
    public String getFactoryId() {
        return factoryId;
    }
    public Tyre getTyre() {
        return tyre;
    }
    public Speaker getSpeaker() {
        return speaker;
    }
    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Vehicle [factoryId="+factoryId+",tyre=" + tyre + ", speaker=" + speaker + ", price=" + price + "]";
    }


}
