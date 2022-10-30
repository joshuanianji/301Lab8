package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * checks if hasCity works
     * adds a new city to the list and checks if that item is, in fact, in the list
     one
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city));
    }

    /**
     * checks if hasCity works
     * adds a new city to the list and checks if that item is, in fact, in the list
     one
     */
    @Test
    public void deleteCityTests(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city));
        list.deleteCity(city);
        Assertions.assertFalse(list.hasCity(city));
    }

    /**
     * Tests if countCities works
     */
    @Test
    public void countCityTests(){
        list = MockCityList();
        City city1 = new City("Estevan", "SK");
        City city2 = new City("Estevan", "SKA");

        list.addCity(city1);
        assertEquals(list.countCities(), 1);
        list.addCity(city2);
        assertEquals(list.countCities(), 2);
        list.deleteCity(city1);
        assertEquals(list.countCities(), 1);
        list.deleteCity(city2);
        assertEquals(list.countCities(), 0);
    }
}
