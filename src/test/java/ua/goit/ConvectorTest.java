package ua.goit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConvectorTest {

    Convector convector = new Convector();
    Product pear = new Product('A',"pear",1.25,3,3.00);
    Product mango = new Product('B',"mango",4.25);
    Product apple = new Product('C',"apple",1.00,6,5.00);
    Product banana = new Product('D',"banana",0.75);
    Map<Character, Integer> expectResult = new HashMap<>();
    List<Product> expectList = new ArrayList<>();

    @Test
    void testConvertToMap(){
        //given
        String code = "ACBDAAA";
        //when
        Map<Character, Integer> actualResult = convector.convertToMap(code);
        //then
        fillMap();
        assertEquals(expectResult,actualResult);
        assertEquals(expectResult.size(),actualResult.size());
        assertEquals(expectResult.get('A'),actualResult.get('A'));
        assertEquals(expectResult.get('B'),actualResult.get('B'));
    }

    private void fillMap() {
        Product pear = new Product('A',"pear",1.25,3,3.00);
        Product mango = new Product('B',"mango",4.25);
        Product apple = new Product('C',"apple",1.00,6,5.00);
        Product banana = new Product('D',"banana",0.75);
        expectResult.put('A',4);
        expectResult.put('B',1);
        expectResult.put('C',1);
        expectResult.put('D',1);
    }

    @Test
    void testConvertToList(){
        //given
        //when
        fillMap();
        List<Product> actualResult = convector.convertToList(convector.convertToMap("ACBDAAA"));
        //then
        fillList();
        assertEquals(expectList,actualResult);
        assertEquals(expectList.size(),actualResult.size());
        assertEquals(expectList.get(2).getName(),actualResult.get(2).getName());
    }

    private void fillList() {
        expectList.add(pear);
        expectList.add(mango);
        expectList.add(apple);
        expectList.add(banana);
        expectList.get(0).setCount(4);
        expectList.get(1).setCount(1);
        expectList.get(2).setCount(1);
        expectList.get(3).setCount(1);
    }
}