package ua.goit;

import java.util.Objects;

public class Product {
    private Character code;
    private String name;
    private double price;
    private int discountCount;
    private double discountPrice;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product(Character code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;

    }

    public Product(Character code, String name, double price, int discountCount, double discountPrice) {
        this.code = code;
        this.name = name;
        this.price = price;

        this.discountCount = discountCount;
        this.discountPrice = discountPrice;
    }

    public Character getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", numberForSale=" + discountCount +
                ", priceWithSale=" + discountPrice +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && discountCount == product.discountCount && Double.compare(product.discountPrice, discountPrice) == 0 && count == product.count && Objects.equals(code, product.code) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, price, discountCount, discountPrice, count);
    }
}
