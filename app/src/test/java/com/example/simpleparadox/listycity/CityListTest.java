package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CityListTest {
    // to create a city to test
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    // add the city to the created cityList
    private City mockCity(){
        City city = new City("Edmonton", "Alberta");
        return city;
    }
    // test the add method on happy path
    @Test
    public void testAddSuccess() {
        CityList mockList = mockCityList();
        assertEquals(1,mockList.getCities().size());
        City newCity = new City("Calgary", "Alberta");
        mockList.add(newCity);
        assertEquals(2,mockList.getCities().size());
    }
    // test the add add method on fail path
    @Test
    public void testAddFailed() {
        CityList cityList = new CityList();
        City mockCity = mockCity();
        cityList.add(mockCity);
        assertEquals(1,cityList.getCities().size());
        assertThrows(IllegalArgumentException.class, () -> { // tell which exception to look for, give the functionnality of how that exception should appear
            cityList.add(mockCity);
        });

    }
    // test the getCity method
    @Test
    public void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(0,city.compareTo(cityList.getCities().get(0))); // caution: getCities would sort the list
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    // test the method hasCity on happy path
    @Test
    public void testHasCityHappy(){
        CityList cityList = mockCityList();
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        boolean result = cityList.hasCity(city);
        assertEquals(true, result);
    }
    // test the method hasCity on fail pass
    @Test
    public void testHasCityFail(){
        CityList cityList = mockCityList();
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Calgary", "Alberta");
        boolean result = cityList.hasCity(city);
        assertEquals(false, result);
    }
    // test the method delete on happy path
    @Test
    public void testDeleteHappy(){
        CityList cityList = mockCityList();
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        cityList.delete(city);
        assertEquals(1, cityList.getCities().size());
    }
    // test the method delete on fail path
    @Test
    public void testDeleteFail(){
        CityList cityList = mockCityList();
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        City city2 = new City("Vancouver", "BC");
        assertEquals(2, cityList.getCities().size());
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city2);
        });
    }
    // test the method countCities
    @Test
    public void testCountCities(){
        CityList cityList = mockCityList();
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(0)));
        int result1 = cityList.countCities();
        assertEquals(1, result1);
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        int result = cityList.countCities();
        assertEquals(2, result);
    }

}
