package com.example.simpleparadox.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

/**
 * THis is a custom list class for City objects
 */
public class CityList {

    /**
     * This is the city list
     */
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a city to the city list if it does not exist already
     * @param city
     *      Prospective city to add to the city list
     */
    public void add(City city){
        if (cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Return the list of cities in a sorted order
     * @return
     *      A sorted list of cities
     */
    public List<City> getCities(){
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }

    /**
     * Return boolean tells if certain city is in the list
     * @param city
     *      Prospective city to check in the city list
     * @return
     *      A boolean value to tell is the city is in the list
     */
    public boolean hasCity(City city){
        boolean has_city = false;
        for (int i = 0; i < cities.size(); i++){
            if (city == cities.get(i)){
                has_city = true;
            }
        }
        return has_city;
    }

    /**
     * This method delete a city from cityList
     * @param city
     *      Prospective city to delete from the list
     */
    public void delete(City city){
        if (!(cities.contains(city))){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This method returns how many cities are in the list
     * @return
     *      An integer value tells how many cities does the list have
     */
    public int countCities(){
        int count = cities.size();
        return count;
    }

}
