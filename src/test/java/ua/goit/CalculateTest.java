package ua.goit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

     private final Calculate calculate = new Calculate();
     private final Convector convector = new Convector();

    Product pear = new Product('A',"pear",1.25,3,3.00);
    Product mango = new Product('B',"mango",4.25);
    Product apple = new Product('C',"apple",1.00,6,5.00);
    Product banana = new Product('D',"banana",0.75);



    @Test
     void testCalculate(){
        //given
        String code = "ACBDAAA";
        //when
        double actualResult = calculate.calculate(code);
        //then
        double expectResult = 10.25;

        assertEquals(expectResult, actualResult);
    }

    @Test
     void testCalculateAAndCWithoutSale(){
        //given
        String code = "ABCDAAA";
        List<Product> list = convector.convertToList(convector.convertToMap(code));
        //when
        double actualResult = calculate.calculateAAndCWithoutSale(list);
        //then
        double expectResult = 1;
        assertEquals(expectResult,actualResult);
    }

    @Test
     void testCalculateBAndD(){
        //given
        String code = "ABCDAAA";
        List<Product> list = convector.convertToList(convector.convertToMap(code));
        //when
        double actualResult = calculate.calculateBAndD(list);
        //then
        double expectResult= 5;
        assertEquals(expectResult,actualResult);
    }

    @Test
     void testCalculateAAndCWithSale(){
        //given
        String code = "ABCDAAA";
        List<Product> list = convector.convertToList(convector.convertToMap(code));
        //when
        double actualResult = calculate.calculateAAndCWithSale(list);
        //then
        double expectResult= 4.25;
        assertEquals(expectResult,actualResult);
    }
}