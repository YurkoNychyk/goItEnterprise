package ua.goit.enterprise.module1;

import java.util.*;

/**
 * Created by home on 23.06.2016.
 */
public class OperationsTimeTest {
    private long startTime;

    public long testAdd (List<Integer> testedList, int item) {

        startTime = System.currentTimeMillis();

        testedList.add(getRandomNumber(testedList.size()), getRandomNumber(testedList.size()));

        return System.currentTimeMillis() - startTime;
    }
    public long testAdd (Set<Integer> testedSet, int item) {

        startTime = System.currentTimeMillis();
        testedSet.add( getRandomNumber(item) );

        return System.currentTimeMillis() - startTime;
    }

    public long testPopulate(Collection<Integer> collection, int collectionSize) {
        startTime = System.currentTimeMillis();

        if (collection instanceof java.util.List) {
            List testedList = (List)collection;
            for (int i=0; i < collectionSize; i++) {
                testedList.add(i, i);
            }
           //System.out.println("Testing population of List\tof " + testedList.size() + " \telements, time is: \t" + (System.currentTimeMillis() - startTime) );
        }
        if (collection instanceof java.util.Set) {

            Set testedSet = (Set) collection;
            for (int i = 0; i < collectionSize; i++) {
                testedSet.add(i);
            }
            //System.out.println("Testing population of Set\tof " + testedSet.size() + " \telements, time is: \t" + (System.currentTimeMillis() - startTime) );
        }
        return System.currentTimeMillis() - startTime;
    }

    private int getRandomNumber(int elementsNumber) {
        return  (int) Math.floor( Math.random() * (elementsNumber+1) ) ;
    }
}
