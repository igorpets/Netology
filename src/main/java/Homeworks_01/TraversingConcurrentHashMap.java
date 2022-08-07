package Homeworks_01;

// Java Program for traversing a
// ConcurrentHashMap
import java.util.*;
import java.util.concurrent.*;

public class TraversingConcurrentHashMap {

    public static void main(String[] args)
    {

        // create an instance of ConcurrentHashMap
        ConcurrentHashMap<Integer, String> chmap
                = new ConcurrentHashMap<Integer, String>();

        // Add elements using put()
        chmap.put(8, "Third");
        chmap.put(6, "Second");
        chmap.put(3, "First");
        chmap.put(11, "Fourth");

        // Create an Iterator over the
        // ConcurrentHashMap
        Iterator<ConcurrentHashMap.Entry<Integer, String> >
                itr = chmap.entrySet().iterator();

        // The hasNext() method is used to check if there is
        // a next element The next() method is used to
        // retrieve the next element
        while (itr.hasNext()) {
            ConcurrentHashMap.Entry<Integer, String> entry
                    = itr.next();
            System.out.println("Key = " + entry.getKey()
                    + ", Value = "
                    + entry.getValue());
        }
    }
}
