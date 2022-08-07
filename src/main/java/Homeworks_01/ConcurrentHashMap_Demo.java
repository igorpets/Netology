package Homeworks_01;

// Java code to illustrate the elements() method

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentHashMap_Demo {
    public static void main(String[] args)
    {

        // Creating an empty hash_map
        ConcurrentHashMap<Integer, String>
                hash_map = new ConcurrentHashMap<Integer,
                String>();

        // Mapping elements into the map
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");

        // Displaying the hash_map
        System.out.println("The Map is: " + hash_map);

        // Creating an empty enumeration to store
        Enumeration enu = hash_map.elements();

        System.out.println("The enumeration of values are:\n");

        // Displaying the Enumeration
        while (enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }
    }
}