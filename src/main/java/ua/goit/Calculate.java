package ua.goit;

import java.util.ArrayList;
import java.util.List;

public class Calculate {

    private static List<Product> products = new ArrayList<>();

    public double calculate(String code){
        List<Product> list = new ArrayList<>();
        Convector order = new Convector();
        list = order.convertToList(order.convertToMap(code));
        double price = 0;
        price  +=  calculateBAndD(list) + calculateAAndCWithoutSale(list) + calculateAAndCWithSale(list);
        return price;
    }

    public double calculateBAndD(List<Product> list){
        double price = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode() == 'B'){
                price += list.get(i).getCount() * list.get(i).getPrice();
            }
            if (list.get(i).getCode() == 'D'){
                price += list.get(i).getCount()* list.get(i).getPrice();
            }
        }
        return price;
    }


    public double calculateAAndCWithoutSale(List<Product> list){
        double price =0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode() == 'A' && list.get(i).getCount() < list.get(i).getDiscountCount()){
                price +=  list.get(i).getCount() * list.get(i).getPrice();
            }
            if (list.get(i).getCode() == 'C' && list.get(i).getCount() < list.get(i).getDiscountCount()){
                price +=  list.get(i).getCount() * list.get(i).getPrice();
            }
        }
        return price;
    }

    public double calculateAAndCWithSale(List<Product> list){
        double price = 0;
        int a = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode() == 'A' && list.get(i).getCount() >= list.get(i).getDiscountCount()){
               a =  list.get(i).getCount() - list.get(i).getDiscountCount();
               price += (a * list.get(i).getPrice()) + list.get(i).getDiscountPrice();
            }
            if (list.get(i).getCode() == 'C' && list.get(i).getCount() >= list.get(i).getDiscountCount()){
                a =  list.get(i).getCount() - list.get(i).getDiscountCount();
                price += (a * list.get(i).getPrice()) + list.get(i).getDiscountPrice();
            }
        }
        return price;
    }





//
//    public static double calculateTotalCost(String code) {
//        products = Order.order(Order.makeOrder(code));
//        double totalPrice = 0;
//        totalPrice +=  calculateBAndD() + calculateAAndCWithoutSale() + calculateAAndCWithSale();
//        return totalPrice;
//    }
//
//    public static double calculateBAndD(){
//        double price = 0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getCode() == 'B'){
//                price += products.get(i).getCount() * products.get(i).getPrice();
//            }
//            if (products.get(i).getCode() == 'D'){
//                price += products.get(i).getCount()* products.get(i).getPrice();
//            }
//        }
//        return price;
//    }
//
//    public static double calculateAAndCWithoutSale(){
//        double price =0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getCode() == 'A' && products.get(i).getCount() < products.get(i).getNumberForSale()){
//                price +=  products.get(i).getCount() * products.get(i).getPrice();
//            }
//            if (products.get(i).getCode() == 'C' && products.get(i).getCount() < products.get(i).getNumberForSale()){
//                price +=  products.get(i).getCount() * products.get(i).getPrice();
//            }
//        }
//        return price;
//    }
//
//    public static double calculateAAndCWithSale(){
//        double price = 0;
//        int a = 0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getCode() == 'A' && products.get(i).getCount() >= products.get(i).getNumberForSale()){
//               a =  products.get(i).getCount() - products.get(i).getNumberForSale();
//               price += (a * products.get(i).getPrice()) + products.get(i).getPriceWithSale();
//            }
//            if (products.get(i).getCode() == 'C' && products.get(i).getCount() >= products.get(i).getNumberForSale()){
//                a =  products.get(i).getCount() - products.get(i).getNumberForSale();
//                price += (a * products.get(i).getPrice()) + products.get(i).getPriceWithSale();
//            }
//        }
//        return price;
//    }
}