package ua.goit.enterprise.module1;

import java.util.ArrayList;

/**
 * Created by home on 23.06.2016.
 */
public class Runner {
    private static final int FACTOR10K = 10000;
    private static final int FACTOR100K = 100000;
    private static final int FACTOR1000K = 1000000;
    private static long startTime;
    public static void main(String[] args) {
        ArrayList<Integer> tested10KList = new ArrayList<>(FACTOR10K);
        ArrayList<Integer> tested100KList = new ArrayList<>(FACTOR100K);
        ArrayList<Integer> tested1000KList = new ArrayList<>(FACTOR1000K);

        startTime = System.nanoTime();
        OperationsTimeTest.doPopulate(tested10KList, FACTOR10K);
        System.out.println("10K list size: " + tested10KList.size());


        startTime = System.nanoTime();
        OperationsTimeTest.doPopulate(tested100KList, FACTOR100K);
        System.out.println("100K list size: " + tested100KList.size());


        startTime = System.nanoTime();
        OperationsTimeTest.doPopulate(tested1000KList, FACTOR1000K);
        System.out.println("1000K list size: " + tested1000KList.size());


        //OperationsTimeTest.doAdd(tested10KList);
        System.out.println(tested10KList);
        System.out.println(tested100KList);
        //System.out.println(tested1000KList);
        OperationsTimeTest.doAdd(tested100KList);
        OperationsTimeTest.doAdd(tested1000KList);
    }
}
