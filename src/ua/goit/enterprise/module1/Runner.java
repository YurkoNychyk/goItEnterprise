package ua.goit.enterprise.module1;

import java.util.*;

/**
 * Created by home on 23.06.2016.
 */
public class Runner {
    private static final int FACTOR10K = 100000;
    private static final int FACTOR100K = 1000000;
    private static final int FACTOR1000K = 10000000;
    private static final int MEASUREMENTS_NUMBER = 100;

    private static OperationsTimeTest tester = new OperationsTimeTest();

    public static void main(String[] args) {
        long arrayList10kAveragePopulationTime = 0;
        long arrayList100kAveragePopulationTime = 0;
        long arrayList1000kAveragePopulationTime = 0;

        long linkedList10kAveragePopulationTime = 0;
        long linkedList100kAveragePopulationTime = 0;
        long linkedList1000kAveragePopulationTime = 0;

        long hashSet10kAveragePopulationTime = 0;
        long hashSet100kAveragePopulationTime = 0;
        long hashSet1000kAveragePopulationTime = 0;

        long treeSet10kAveragePopulationTime = 0;
        long treeSet100kAveragePopulationTime = 0;
        long treeSet1000kAveragePopulationTime = 0;

        for (int i=0; i<MEASUREMENTS_NUMBER; i++)   {
            List<Integer> tested10kArrayList = new ArrayList<>(FACTOR10K);
            List<Integer> tested100kArrayList = new ArrayList<>(FACTOR100K);
            List<Integer> tested1000kArrayList = new ArrayList<>(FACTOR1000K);

            List<Integer> tested10kLinkedList = new LinkedList<>();
            List<Integer> tested100kLinkedList = new LinkedList<>();
            List<Integer> tested1000kLinkedList = new LinkedList<>();

            Set<Integer> tested10kHashSet = new HashSet<>(FACTOR10K);
            Set<Integer> tested100kHashSet = new HashSet<>(FACTOR100K);
            Set<Integer> tested1000kHashSet = new HashSet<>(FACTOR1000K);

            Set<Integer> tested10kTreeSet = new TreeSet<>();
            Set<Integer> tested100kTreeSet = new TreeSet<>();
            Set<Integer> tested1000kTreeSet = new TreeSet<>();

            arrayList10kAveragePopulationTime += tester.testPopulate(tested10kArrayList, FACTOR10K);
            arrayList100kAveragePopulationTime += tester.testPopulate(tested100kArrayList, FACTOR100K);
            arrayList1000kAveragePopulationTime += tester.testPopulate(tested1000kArrayList, FACTOR1000K);

            linkedList10kAveragePopulationTime += tester.testPopulate(tested10kLinkedList, FACTOR10K);
            linkedList100kAveragePopulationTime += tester.testPopulate(tested100kLinkedList, FACTOR100K);
            linkedList1000kAveragePopulationTime += tester.testPopulate(tested1000kLinkedList, FACTOR1000K);

            hashSet10kAveragePopulationTime += tester.testPopulate(tested10kHashSet, FACTOR10K);
            hashSet100kAveragePopulationTime += tester.testPopulate(tested100kHashSet, FACTOR100K);
            hashSet1000kAveragePopulationTime += tester.testPopulate(tested1000kHashSet, FACTOR1000K);

            treeSet10kAveragePopulationTime += tester.testPopulate(tested10kTreeSet, FACTOR10K);
            treeSet100kAveragePopulationTime += tester.testPopulate(tested100kTreeSet, FACTOR100K);
            treeSet1000kAveragePopulationTime += tester.testPopulate(tested1000kTreeSet, FACTOR1000K);
        }

        arrayList10kAveragePopulationTime = arrayList10kAveragePopulationTime / MEASUREMENTS_NUMBER;
        arrayList100kAveragePopulationTime = arrayList100kAveragePopulationTime / MEASUREMENTS_NUMBER;
        arrayList1000kAveragePopulationTime = arrayList1000kAveragePopulationTime / MEASUREMENTS_NUMBER;

        linkedList10kAveragePopulationTime = linkedList10kAveragePopulationTime / MEASUREMENTS_NUMBER;
        linkedList100kAveragePopulationTime = linkedList100kAveragePopulationTime / MEASUREMENTS_NUMBER;
        linkedList1000kAveragePopulationTime = linkedList1000kAveragePopulationTime / MEASUREMENTS_NUMBER;

        hashSet10kAveragePopulationTime= hashSet10kAveragePopulationTime/ MEASUREMENTS_NUMBER;
        hashSet100kAveragePopulationTime= hashSet100kAveragePopulationTime/ MEASUREMENTS_NUMBER;
        hashSet1000kAveragePopulationTime= hashSet1000kAveragePopulationTime/ MEASUREMENTS_NUMBER;

        treeSet10kAveragePopulationTime = treeSet10kAveragePopulationTime / MEASUREMENTS_NUMBER;
        treeSet100kAveragePopulationTime = treeSet100kAveragePopulationTime / MEASUREMENTS_NUMBER;
        treeSet1000kAveragePopulationTime = treeSet1000kAveragePopulationTime / MEASUREMENTS_NUMBER;

        System.out.println();
        System.out.println("ArrayList:");
        System.out.println("10K\tPopulate time: " + arrayList10kAveragePopulationTime);
        System.out.println("100K\tPopulate time: " + arrayList100kAveragePopulationTime);
        System.out.println("1000K\tPopulate time: " + arrayList1000kAveragePopulationTime);
        System.out.println();
        System.out.println("LinkedList:");
        System.out.println("10K\tPopulate time: " + linkedList10kAveragePopulationTime);
        System.out.println("100K\tPopulate time: " + linkedList100kAveragePopulationTime);
        System.out.println("1000K\tPopulate time: " + linkedList1000kAveragePopulationTime);
        System.out.println();
        System.out.println("HashSet:");
        System.out.println("10K\tPopulate time: " + hashSet10kAveragePopulationTime);
        System.out.println("100K\tPopulate time: " + hashSet100kAveragePopulationTime);
        System.out.println("1000K\tPopulate time: " + hashSet1000kAveragePopulationTime);
        System.out.println();
        System.out.println("TreeSet:");
        System.out.println("10K\tPopulate time: " + treeSet10kAveragePopulationTime);
        System.out.println("100K\tPopulate time: " + treeSet100kAveragePopulationTime);
        System.out.println("1000K\tPopulate time: " + treeSet1000kAveragePopulationTime);
    }

}
