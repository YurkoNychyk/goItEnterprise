package ua.goit.enterprise.module1;

import java.util.*;

/**
 * Created by home on 23.06.2016.
 */
public class Runner {
    private static final int FACTOR10K = 10000;
    private static final int FACTOR100K = 100000;
    private static final int FACTOR1000K = 1000000;

    public static final String ARRAYLIST10KPOPULATERESULT = "ArrayList 10K average population time";
    public static final String ARRAYLIST100KPOPULATERESULT = "ArrayList 100K average population time";
    public static final String ARRAYLIST1000KPOPULATERESULT = "ArrayList 1000K average population time";

    public static final String LINKEDLIST10KPOPULATERESULT = "LinkedList 10K average population time";
    public static final String LINKEDLIST100KPOPULATERESULT = "LinkedList 100K average population time";
    public static final String LINKEDLIST1000KPOPULATERESULT = "LinkedList 1000K average population time";

    public static final String HASHSET10KPOPULATERESULT = "HashSet 10K average population time";
    public static final String HASHSET100KPOPULATERESULT = "HashSet 100K average population time";
    public static final String HASHSET1000KPOPULATERESULT = "HashSet 1000K average population time";

    public static final String TREESET10KPOPULATERESULT = "TreeSet 10K average population time";
    public static final String TREESET100KPOPULATERESULT = "TreeSet 100K average population time";
    public static final String TREESET1000KPOPULATERESULT = "TreeSet 1000K average population time";

    private static final int MEASUREMENTS_NUMBER = 1;

    private static OperationsTimeTest tester = new OperationsTimeTest();

    public static Map<String, Long> testResults = new HashMap<>();


    static long arrayList10kAveragePopulationTime = 0;
    static long arrayList100kAveragePopulationTime = 0;
    static long arrayList1000kAveragePopulationTime = 0;

    static long linkedList10kAveragePopulationTime = 0;
    static long linkedList100kAveragePopulationTime = 0;
    static long linkedList1000kAveragePopulationTime = 0;

    static long hashSet10kAveragePopulationTime = 0;
    static long hashSet100kAveragePopulationTime = 0;
    static long hashSet1000kAveragePopulationTime = 0;

    static long treeSet10kAveragePopulationTime = 0;
    static long treeSet100kAveragePopulationTime = 0;
    static long treeSet1000kAveragePopulationTime = 0;



    static List<Integer> tested10kArrayList;
    static List<Integer> tested100kArrayList;
    static List<Integer> tested1000kArrayList;

    static List<Integer> tested10kLinkedList;
    static List<Integer> tested100kLinkedList;
    static List<Integer> tested1000kLinkedList;

    static Set<Integer> tested10kHashSet;
    static Set<Integer> tested100kHashSet;
    static Set<Integer> tested1000kHashSet;

    static Set<Integer> tested10kTreeSet;
    static Set<Integer> tested100kTreeSet;
    static Set<Integer> tested1000kTreeSet;



    public static void main(String[] args) {

        testPopulate();

        printResultsToConsole();


    }
    public static void printResultsToConsole()   {

        System.out.println();
        System.out.println(ARRAYLIST10KPOPULATERESULT + ":\t" + testResults.get(ARRAYLIST10KPOPULATERESULT) + "ms.");
        System.out.println(ARRAYLIST100KPOPULATERESULT + ":\t" + testResults.get(ARRAYLIST100KPOPULATERESULT) + "ms.");
        System.out.println(ARRAYLIST1000KPOPULATERESULT + ":\t" + testResults.get(ARRAYLIST1000KPOPULATERESULT) + "ms.");

        System.out.println();
        System.out.println(LINKEDLIST10KPOPULATERESULT + ":\t" + testResults.get(LINKEDLIST10KPOPULATERESULT) + "ms.");
        System.out.println(LINKEDLIST100KPOPULATERESULT + ":\t" + testResults.get(LINKEDLIST100KPOPULATERESULT)+ "ms.");
        System.out.println(LINKEDLIST1000KPOPULATERESULT + ":\t" + testResults.get(LINKEDLIST1000KPOPULATERESULT) + "ms.");

        System.out.println();
        System.out.println(HASHSET10KPOPULATERESULT + ":\t" + testResults.get(HASHSET10KPOPULATERESULT)+ "ms.");
        System.out.println(HASHSET100KPOPULATERESULT + ":\t" + testResults.get(HASHSET100KPOPULATERESULT) + "ms.");
        System.out.println(HASHSET1000KPOPULATERESULT + ":\t" + testResults.get(HASHSET1000KPOPULATERESULT) + "ms.");

        System.out.println();
        System.out.println(TREESET10KPOPULATERESULT + ":\t" + testResults.get(TREESET10KPOPULATERESULT) + "ms.");
        System.out.println(TREESET100KPOPULATERESULT + ":\t" + testResults.get(TREESET100KPOPULATERESULT)+ "ms.");
        System.out.println(TREESET1000KPOPULATERESULT + ":\t" + testResults.get(TREESET1000KPOPULATERESULT)+ "ms.");

    }

    private static void testPopulate() {

        for (int i = 0; i < MEASUREMENTS_NUMBER; i++) {
            tested10kArrayList = new ArrayList<>(FACTOR10K);
            tested100kArrayList = new ArrayList<>(FACTOR100K);
            tested1000kArrayList = new ArrayList<>(FACTOR1000K);

            tested10kLinkedList = new LinkedList<>();
            tested100kLinkedList = new LinkedList<>();
            tested1000kLinkedList = new LinkedList<>();

            tested10kHashSet = new HashSet<>(FACTOR10K);
            tested100kHashSet = new HashSet<>(FACTOR100K);
            tested1000kHashSet = new HashSet<>(FACTOR1000K);

            tested10kTreeSet = new TreeSet<>();
            tested100kTreeSet = new TreeSet<>();
            tested1000kTreeSet = new TreeSet<>();


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
            System.out.println(System.currentTimeMillis() + " Populate measurement " + i + "\tfinished");
        }

        testResults.put(ARRAYLIST10KPOPULATERESULT, arrayList10kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults.put(ARRAYLIST100KPOPULATERESULT, arrayList100kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults.put(ARRAYLIST1000KPOPULATERESULT, arrayList1000kAveragePopulationTime / MEASUREMENTS_NUMBER);
        //arrayList10kAveragePopulationTime = arrayList10kAveragePopulationTime / MEASUREMENTS_NUMBER;
        //arrayList100kAveragePopulationTime = arrayList100kAveragePopulationTime / MEASUREMENTS_NUMBER;
        //arrayList1000kAveragePopulationTime = arrayList1000kAveragePopulationTime / MEASUREMENTS_NUMBER;

        //linkedList10kAveragePopulationTime = linkedList10kAveragePopulationTime / MEASUREMENTS_NUMBER;
        //linkedList100kAveragePopulationTime = linkedList100kAveragePopulationTime / MEASUREMENTS_NUMBER;
        //linkedList1000kAveragePopulationTime = linkedList1000kAveragePopulationTime / MEASUREMENTS_NUMBER;
        testResults.put(LINKEDLIST10KPOPULATERESULT, linkedList10kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults.put(LINKEDLIST100KPOPULATERESULT, linkedList100kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults.put(LINKEDLIST1000KPOPULATERESULT, linkedList1000kAveragePopulationTime / MEASUREMENTS_NUMBER);

        //hashSet10kAveragePopulationTime = hashSet10kAveragePopulationTime / MEASUREMENTS_NUMBER;
        //hashSet100kAveragePopulationTime = hashSet100kAveragePopulationTime / MEASUREMENTS_NUMBER;
        //hashSet1000kAveragePopulationTime = hashSet1000kAveragePopulationTime / MEASUREMENTS_NUMBER;
        testResults.put(HASHSET10KPOPULATERESULT, hashSet10kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults.put(HASHSET100KPOPULATERESULT, hashSet100kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults.put(HASHSET1000KPOPULATERESULT, hashSet1000kAveragePopulationTime / MEASUREMENTS_NUMBER);

        //treeSet10kAveragePopulationTime = treeSet10kAveragePopulationTime / MEASUREMENTS_NUMBER;
        //treeSet100kAveragePopulationTime = treeSet100kAveragePopulationTime / MEASUREMENTS_NUMBER;
        //treeSet1000kAveragePopulationTime = treeSet1000kAveragePopulationTime / MEASUREMENTS_NUMBER;
        testResults.put(TREESET10KPOPULATERESULT, treeSet10kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults.put(TREESET100KPOPULATERESULT, treeSet100kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults.put(TREESET1000KPOPULATERESULT, treeSet1000kAveragePopulationTime / MEASUREMENTS_NUMBER);



    }

    private static void testAdd(){
        for(int i = 0; i <= MEASUREMENTS_NUMBER; i++)   {
            int randomIndex = (int) (Math.floor( Math.random() * (tested10kArrayList.size()+1) )) ;
            tester.testAdd(tested10kArrayList, randomIndex);
            tester.testAdd(tested10kLinkedList, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested100kArrayList.size()+1) )) ;
            tester.testAdd(tested100kArrayList, randomIndex);
            tester.testAdd(tested100kLinkedList, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested1000kArrayList.size()+1) )) ;
            tester.testAdd(tested1000kArrayList, randomIndex);
            tester.testAdd(tested1000kLinkedList, randomIndex);


            randomIndex = (int) (Math.floor( Math.random() * (tested10kHashSet.size()+1) )) ;
            tester.testAdd(tested10kHashSet, randomIndex);
            randomIndex = (int) (Math.floor( Math.random() * (tested100kHashSet.size()+1) )) ;
            tester.testAdd(tested100kHashSet, randomIndex);
            randomIndex = (int) (Math.floor( Math.random() * (tested1000kHashSet.size()+1) )) ;
            tester.testAdd(tested1000kHashSet, randomIndex);

            System.out.println(System.currentTimeMillis() + " Add measurement " + i + "\tfinished");
        }
    }
}
