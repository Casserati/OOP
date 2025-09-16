package hslu.oop.sw01;

public class Product {

    private int quantity;
    private String name;
    private double price;
    private VatType vatType;

    Product(String name, double price, VatType vatType) {
        this.quantity = 1;
        this.name = name;
        this.price = price;
        this.vatType = vatType;
    }

    Product(int quantity, String name, double price, VatType vatType) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.vatType = vatType;
    }

    public double getPrice() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity(){
        return quantity;
    }
}
