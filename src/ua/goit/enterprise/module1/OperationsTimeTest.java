package ua.goit.enterprise.module1;

import java.util.*;

/**
 * Created by home on 23.06.2016.
 */
public class OperationsTimeTest {
    private final int TIMEDIVIDER = 1000;
    private long startTime;

    public long testAdd (List<Integer> testedList, int item) {

        startTime = System.nanoTime();

        testedList.add(getRandomNumber(testedList.size()), item);

        return (System.nanoTime() - startTime) / TIMEDIVIDER;
    }
    public long testAdd (Set<Integer> testedSet, int item) {

        startTime = System.nanoTime();
        System.out.println( "set.add(): " + testedSet.add( item ) + "\t" + item );

        return (System.nanoTime() - startTime) / TIMEDIVIDER;
    }

    public long testGet(List<Integer>testedList, int item){

        startTime = System.nanoTime();
        testedList.get(item);

        return (System.nanoTime() - startTime) / TIMEDIVIDER;
    }

    public long testRemove(Set<Integer> testedSet, int item){

        startTime = System.nanoTime();
        System.out.println("set.remove(): " + testedSet.remove(item) + "\t" + item);
        return (System.nanoTime() - startTime) / TIMEDIVIDER;

    }

    public long testContains(Collection<Integer> testedCollection, int item){

        startTime = System.nanoTime();
        testedCollection.contains(item);

        return (System.nanoTime() - startTime) / TIMEDIVIDER;
    }

    public long testPopulate(Collection<Integer> testedCollection, int collectionSize) {
        startTime = System.nanoTime();

        if (testedCollection instanceof java.util.List) {
            List testedList = (List)testedCollection;
            for (int i=0; i < collectionSize; i++) {
                testedList.add(i, i);
            }
        }
        if (testedCollection instanceof java.util.Set) {

            Set testedSet = (Set) testedCollection;
            for (int i = 0; i < collectionSize; i++) {
                testedSet.add(i);
            }
        }
        return (System.nanoTime() - startTime) / TIMEDIVIDER;
    }

    public long testIteratorAdd(List<Integer> testedCollection, int item, int measurementsNumber){

        int currentMeasurement = 0;
        long operationTime = 0;
        ListIterator<Integer> iter = testedCollection.listIterator();

        while (currentMeasurement < measurementsNumber){
            startTime = System.nanoTime();
            iter.add(item);
            operationTime += System.nanoTime()- startTime;
            currentMeasurement++;
        }
        return operationTime / measurementsNumber / TIMEDIVIDER ;

    }

    public long testIteratorRemove(Set<Integer> testedCollection, int measurementsNumber){
        int currentMeasurement = 0;
        long operationTime = 0;
        Iterator<Integer> iter = testedCollection.iterator();

        while (currentMeasurement < measurementsNumber){
            startTime = System.nanoTime();
            iter.remove();
            operationTime += System.nanoTime()- startTime;
            currentMeasurement++;
        }
        return operationTime / measurementsNumber / TIMEDIVIDER ;
    }

    private int getRandomNumber(int elementsNumber) {
        return  (int) Math.floor( Math.random() * (elementsNumber+1) ) ;
    }
}
