package ua.goit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> productList = new ArrayList<>();
    private static Calculate calculate = new Calculate();

    public static void main(String[] args) {
        Product pear = new Product('A',"pear",1.25,3,3.00);
        Product mango = new Product('B',"mango",4.25);
        Product apple = new Product('C',"apple",1.00,6,5.00);
        Product banana = new Product('D',"banana",0.75);

        productList.add(pear);
        productList.add(mango);
        productList.add(apple);
        productList.add(banana);

        System.out.println("Welcome to a store!\nWe have: \npears(A), mango(B), apples(C) and bananas(D) in the store ");
        System.out.println("Please, enter code of every product:");
        String order = new Scanner(System.in).nextLine();

        System.out.println("Total price gets " + calculate.calculate(order));
    }
}
