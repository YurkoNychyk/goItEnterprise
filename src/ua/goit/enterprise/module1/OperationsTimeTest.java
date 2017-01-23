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
    public static  void doPopulate(ArrayList<Integer> testedCollection, int size) {
        for (int i = 0; i < size; i++){
            testedCollection.add(i);
        }
    }

    private int getRandomIndex (int elementsNumber) {
        return  (int) Math.floor( Math.random() * (elementsNumber+1) ) ;
    }
}
