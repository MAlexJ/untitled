package com.malex;

import java.util.*;

/**
 * Created by Home PC on 08.06.2016.
 */
public class City {
    private String name;

    private Map<City, Integer> cost = new HashMap<>();

    public City(String name) {
        this.name = name;
    }

    public City() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


   public void addToMap(City city, Integer cost){
      this.cost.put(city,cost);
   }

    public Map<City, Integer> getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return(name.equals(city.name));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
