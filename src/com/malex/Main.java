package com.malex;

import java.util.*;

/**
 * Created by Home PC on 08.06.2016.
 */
public class Main {

    public static void main(String[] args) {
        List<City> list = new LinkedList<>();
        int countCity = 4;

        City A = new City();
        A.setName("A");
        A.addToMap(new City("B"), 2);
        A.addToMap(new City("C"), 5);
        list.add(A);

        City B = new City();
        B.setName("B");
        B.addToMap(new City("A"), 2);
        B.addToMap(new City("C"), 1);
        B.addToMap(new City("D"), 4);
        list.add(B);

        City C = new City();
        C.setName("C");
        C.addToMap(new City("A"), 5);
        C.addToMap(new City("B"), 1);
        C.addToMap(new City("D"), 1);
        list.add(C);

        City D = new City();
        D.setName("D");
        D.addToMap(new City("B"), 4);
        D.addToMap(new City("C"), 1);
        list.add(D);

        itemCity(A, D, list, new LinkedHashSet<>(), countCity);

    }


    private static void itemCity(City source, City desc, List<City> list, Set<String> exceptionList, int countCity) {
        countCity--;

        City actualSource = new City();

        if (source.equals(desc)) {
            exceptionList.add(source.getName());

            System.out.println(exceptionList);
            return;
        }
        for (City city : list) {
            if (city.equals(source)) {
                actualSource = city;
            }
        }
        for (City newSource : actualSource.getCost().keySet()) {
            Set<String> newExceptionList = new LinkedHashSet<>(exceptionList);
            newExceptionList.add(source.getName());
            if (countCity > 0) {
                itemCity(newSource, desc, list, newExceptionList, countCity);
            }
        }
    }
}
