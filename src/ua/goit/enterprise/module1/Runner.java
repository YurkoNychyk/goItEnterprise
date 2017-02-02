package ua.goit.enterprise.module1;

import java.util.*;

/**
 * Created by home on 23.06.2016.
 */
public class Runner {
    private static final int FACTOR10K = 10000;
    private static final int FACTOR100K = 100000;
    private static final int FACTOR1000K = 1000000;

    private static final int MEASUREMENTS_NUMBER = 1;

    private static final int FIRST_WINDOW_X_COORDINATE = 100;
    private static final int WINDOWS_GAP = 20;

    public static final String ARRAYLIST_POPULATE_TEST_NAME = "ArrayList.populate";
    public static final String ARRAYLIST_ADD_TEST_NAME = "ArrayList.add";


    public static final String LINKEDLIST_POPULATE_TEST_NAME = "LinkedList.populate";
    public static final String LINKEDLIST_ADD_TEST_NAME = "LinkedList 100K average population time";


    public static final String HASHSET_POPULATE_TEST_NAME = "HashSet.populate";
    public static final String HASHSET_ADD_TEST_NAME = "HashSet 100K average population time";


    public static final String TREESET_POPULATE_TEST_NAME = "TreeSet.populate";
    public static final String TREESET_ADD_TEST_NAME = "TreeSet 100K average population time";


    private static OperationsTimeTest tester = new OperationsTimeTest();
    private static GraphicResults resultWindow10K;
    private static GraphicResults resultWindow100K;
    private static GraphicResults resultWindow1000K;

    public static Map<String, Long> testResults10K = new HashMap<>();
    public static Map<String, Long> testResults100K = new HashMap<>();
    public static Map<String, Long> testResults1000K = new HashMap<>();


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
        testAdd();
        showResults();
        //printResultsToConsole();


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
        }

        testResults10K.put(ARRAYLIST_POPULATE_TEST_NAME, arrayList10kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults100K.put(ARRAYLIST_POPULATE_TEST_NAME, arrayList100kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults1000K.put(ARRAYLIST_POPULATE_TEST_NAME, arrayList1000kAveragePopulationTime / MEASUREMENTS_NUMBER);

        testResults10K.put(LINKEDLIST_POPULATE_TEST_NAME, linkedList10kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults100K.put(LINKEDLIST_POPULATE_TEST_NAME, linkedList100kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults1000K.put(LINKEDLIST_POPULATE_TEST_NAME, linkedList1000kAveragePopulationTime / MEASUREMENTS_NUMBER);

        testResults10K.put(HASHSET_POPULATE_TEST_NAME, hashSet10kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults100K.put(HASHSET_POPULATE_TEST_NAME, hashSet100kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults1000K.put(HASHSET_POPULATE_TEST_NAME, hashSet1000kAveragePopulationTime / MEASUREMENTS_NUMBER);

        testResults10K.put(TREESET_POPULATE_TEST_NAME, treeSet10kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults100K.put(TREESET_POPULATE_TEST_NAME, treeSet100kAveragePopulationTime / MEASUREMENTS_NUMBER);
        testResults1000K.put(TREESET_POPULATE_TEST_NAME, treeSet1000kAveragePopulationTime / MEASUREMENTS_NUMBER);



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

    private static void showResults() {
        resultWindow10K = new GraphicResults("10K Collection operation time complexity test results",FIRST_WINDOW_X_COORDINATE, testResults10K);
        resultWindow100K = new GraphicResults("100K Collection operation time complexity test results",resultWindow10K.getWidth() + FIRST_WINDOW_X_COORDINATE + WINDOWS_GAP, testResults100K);
        resultWindow1000K = new GraphicResults("1000K Collection operation time complexity test results", resultWindow100K.getWidth() + resultWindow100K.getX() + WINDOWS_GAP,testResults1000K);
    }

}
