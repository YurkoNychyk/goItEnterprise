package ua.goit.enterprise.module1;

import java.util.*;

/**
 * Created by home on 23.06.2016.
 */
public class OperationsTimeTest {
    private long startTime;

    public long doAdd (Collection<Integer> collection){

        startTime = System.currentTimeMillis();

        if (collection instanceof java.util.List) {
            List testedList = (List)collection;
            testedList.add( getRandomIndex(collection.size()),getRandomIndex(collection.size()) );
        }
        if (collection instanceof java.util.Set) {
            Set testedSet = (Set)collection;
            testedSet.add(getRandomIndex(collection.size()));
        }

        return System.currentTimeMillis() - startTime;
    }
    public long testPopulate(Collection<Integer> collection, int collectionSize) {
        startTime = System.currentTimeMillis();

        if (collection instanceof java.util.List) {
            List testedList = (List)collection;
            for (int i=0; i < collectionSize; i++) {
                testedList.add(i, getRandomIndex(collectionSize));
            }
            System.out.println("Testing population of List\tof " + testedList.size() + "\telements, time is: \t" + (System.currentTimeMillis() - startTime) );
        }
        if (collection instanceof java.util.Set) {

            Set testedSet = (Set) collection;
            for (int i = 0; i < collectionSize; i++) {
                testedSet.add(getRandomIndex(collectionSize));
            }
            System.out.println("Testing population of Set\tof " + testedSet.size() + "\telements, time is: \t" + (System.currentTimeMillis() - startTime) );
        }
        return System.currentTimeMillis() - startTime;
    }

    private int getRandomIndex (int elementsNumber) {
        return  (int) Math.floor( Math.random() * (elementsNumber+1) ) ;
    }
}
