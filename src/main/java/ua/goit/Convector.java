package ua.goit;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Convector {

    public  Map<Character, Integer> convertToMap(String code){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            int num = 0;
            for (int j = 0; j < code.length(); j++) {
                char c1 = code.charAt(j);
                if(c==c1){
                    num++;
                }
            }
            hashMap.put(c, num);
        }
        return hashMap;
    }

    public  List<Product> convertToList(Map<Character, Integer> o){
        List<Product> b = fillListOfProduct();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < b.size(); i++) {
            Product a = b.get(i);
            Character keys [] = o.keySet().toArray(new Character[0]);
            Integer [] values = o.values().toArray(new Integer[0]);

            for (Character c: keys) {
                if (a.getCode() == c){
                    a.setCount(o.get(c));
                }
            }

            products.add(a);
        }

        return products;
    }

    public List<Product> fillListOfProduct(){
        List<Product> a = new ArrayList<>();
        Product pear = new Product('A',"pear",1.25,3,3.00);
        Product mango = new Product('B',"mango",4.25);
        Product apple = new Product('C',"apple",1.00,6,5.00);
        Product banana = new Product('D',"banana",0.75);
        a.add(pear);
        a.add(mango);
        a.add(apple);
        a.add(banana);
        return a;
    }
}
