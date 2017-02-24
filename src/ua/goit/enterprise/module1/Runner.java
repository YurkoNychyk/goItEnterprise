package ua.goit.enterprise.module1;

import java.util.*;

/**
 * Created by home on 23.06.2016.
 */
public class Runner {
    private static final int FACTOR10K = 10000;
    private static final int FACTOR100K = 100000;
    private static final int FACTOR1000K = 1000000;

    private static final int MEASUREMENTS_NUMBER = 100;

    private static final int FIRST_WINDOW_X_COORDINATE = 10;
    private static final int FIRST_WINDOW_Y_COORDINATE = 10;
    private static final int WINDOW_DEFAULT_HEIGHT = 150;
    private static final int WINDOWS_GAP = 20;

    public static final String ARRAYLIST_POPULATE_TEST_NAME = "ArrayList, populate";
    public static final String ARRAYLIST_ADD_TEST_NAME = "ArrayList, add";
    public static final String ARRAYLIST_GET_TEST_NAME = "ArrayList, get";
    public static final String ARRAYLIST_CONTAINS_TEST_NAME = "ArrayList, contains";
    public static final String ARRAYLIST_ITERATOR_ADD_TEST_NAME = "ArrayList, iterator.add";
    public static final String ARRAYLIST_ITERATOR_REMOVE_TEST_NAME = "ArrayList, iterator.remove";

    public static final String LINKEDLIST_POPULATE_TEST_NAME = "LinkedList, populate";
    public static final String LINKEDLIST_ADD_TEST_NAME = "LinkedList, add";
    public static final String LINKEDLIST_GET_TEST_NAME = "LinkedList, get";
    public static final String LINKEDLIST_CONTAINS_TEST_NAME = "LinkedList, contains";
    public static final String LINKEDLIST_ITERATOR_ADD_TEST_NAME = "LinkedList, iterator.add";
    public static final String LINKEDLIST_ITERATOR_REMOVE_TEST_NAME = "LinkedList, iterator.remove";

    public static final String HASHSET_POPULATE_TEST_NAME = "HashSet, populate";
    public static final String HASHSET_ADD_TEST_NAME = "HashSet, add";
    public static final String HASHSET_REMOVE_TEST_NAME = "HashSet, remove";
    public static final String HASHSET_CONTAINS_TEST_NAME = "HashSet, contains";
    public static final String HASHSET_ITERATOR_REMOVE_TEST_NAME = "HashSet, iterator.remove";

    public static final String TREESET_POPULATE_TEST_NAME = "TreeSet, populate";
    public static final String TREESET_ADD_TEST_NAME = "TreeSet, add";
    public static final String TREESET_REMOVE_TEST_NAME = "TreeSet, remove";
    public static final String TREESET_CONTAINS_TEST_NAME = "TreeSet, contains";
    public static final String TREESET_ITERATOR_REMOVE_TEST_NAME = "TreeSet, iterator.remove";

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

    static long arrayList10kAverageAddTime = 0;
    static long arrayList100kAverageAddTime = 0;
    static long arrayList1000kAverageAddTime = 0;

    static long linkedList10kAverageAddTime = 0;
    static long linkedList100kAverageAddTime = 0;
    static long linkedList1000kAverageAddTime = 0;

    static long hashSet10kAverageAddTime = 0;
    static long hashSet100kAverageAddTime = 0;
    static long hashSet1000kAverageAddTime = 0;

    static long treeSet10kAverageAddTime = 0;
    static long treeSet100kAverageAddTime = 0;
    static long treeSet1000kAverageAddTime = 0;

    static long arrayList10kAverageGetTime = 0;
    static long arrayList100kAverageGetTime = 0;
    static long arrayList1000kAverageGetTime = 0;

    static long linkedList10kAverageGetTime = 0;
    static long linkedList100kAverageGetTime = 0;
    static long linkedList1000kAverageGetTime = 0;

    static long hashSet10kAverageRemoveTime = 0;
    static long hashSet100kAverageRemoveTime = 0;
    static long hashSet1000kAverageRemoveTime = 0;

    static long treeSet10kAverageRemoveTime = 0;
    static long treeSet100kAverageRemoveTime = 0;
    static long treeSet1000kAverageRemoveTime = 0;

    static long arrayList10kAverageContainsTime = 0;
    static long arrayList100kAverageContainsTime = 0;
    static long arrayList1000kAverageContainsTime = 0;

    static long linkedList10kAverageContainsTime = 0;
    static long linkedList100kAverageContainsTime = 0;
    static long linkedList1000kAverageContainsTime = 0;

    static long hashSet10kAverageContainsTime = 0;
    static long hashSet100kAverageContainsTime = 0;
    static long hashSet1000kAverageContainsTime = 0;

    static long treeSet10kAverageContainsTime = 0;
    static long treeSet100kAverageContainsTime = 0;
    static long treeSet1000kAverageContainsTime = 0;


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
        testGet();
        testRemove();
        testContains();
        testIteratorAdd();
        testIteratorRemove();

        System.out.println(testResults10K );
        System.out.println(testResults100K);
        System.out.println(testResults1000K);

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
            arrayList10kAverageAddTime += tester.testAdd(tested10kArrayList, randomIndex);
            linkedList10kAverageAddTime += tester.testAdd(tested10kLinkedList, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested100kArrayList.size()+1) )) ;
            arrayList100kAverageAddTime += tester.testAdd(tested100kArrayList, randomIndex);
            linkedList100kAverageAddTime += tester.testAdd(tested100kLinkedList, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested1000kArrayList.size()+1) )) ;
            arrayList1000kAverageAddTime += tester.testAdd(tested1000kArrayList, randomIndex);
            linkedList1000kAverageAddTime += tester.testAdd(tested1000kLinkedList, randomIndex);


            hashSet10kAverageAddTime += tester.testAdd(tested10kHashSet, tested10kHashSet.size() + 1);
            hashSet100kAverageAddTime += tester.testAdd(tested100kHashSet, tested100kHashSet.size() +1);
            hashSet1000kAverageAddTime += tester.testAdd(tested1000kHashSet, tested1000kHashSet.size() +1);


            treeSet10kAverageAddTime += tester.testAdd(tested10kTreeSet, tested10kTreeSet.size() +1);
            treeSet100kAverageAddTime += tester.testAdd(tested100kTreeSet, tested100kTreeSet.size() +1);
            treeSet1000kAverageAddTime += tester.testAdd(tested1000kTreeSet, tested1000kTreeSet.size() +1);
        }
        testResults10K.put(ARRAYLIST_ADD_TEST_NAME, arrayList10kAverageAddTime / MEASUREMENTS_NUMBER);
        testResults100K.put(ARRAYLIST_ADD_TEST_NAME, arrayList100kAverageAddTime/ MEASUREMENTS_NUMBER);
        testResults1000K.put(ARRAYLIST_ADD_TEST_NAME, arrayList1000kAverageAddTime/ MEASUREMENTS_NUMBER);

        testResults10K.put(LINKEDLIST_ADD_TEST_NAME, linkedList10kAverageAddTime/ MEASUREMENTS_NUMBER);
        testResults100K.put(LINKEDLIST_ADD_TEST_NAME, linkedList100kAverageAddTime/ MEASUREMENTS_NUMBER);
        testResults1000K.put(LINKEDLIST_ADD_TEST_NAME, linkedList1000kAverageAddTime/ MEASUREMENTS_NUMBER);

        testResults10K.put(HASHSET_ADD_TEST_NAME, hashSet10kAverageAddTime / MEASUREMENTS_NUMBER);
        testResults100K.put(HASHSET_ADD_TEST_NAME, hashSet100kAverageAddTime/ MEASUREMENTS_NUMBER);
        testResults1000K.put(HASHSET_ADD_TEST_NAME, hashSet1000kAverageAddTime/ MEASUREMENTS_NUMBER);

        testResults10K.put(TREESET_ADD_TEST_NAME, treeSet10kAverageAddTime / MEASUREMENTS_NUMBER);
        testResults100K.put(TREESET_ADD_TEST_NAME, treeSet100kAverageAddTime/ MEASUREMENTS_NUMBER);
        testResults1000K.put(TREESET_ADD_TEST_NAME, treeSet1000kAverageAddTime/ MEASUREMENTS_NUMBER);
    }

    private static void testGet(){
        for(int i = 0; i <= MEASUREMENTS_NUMBER; i++)   {
            int randomIndex = (int) (Math.floor( Math.random() * (tested10kArrayList.size()+1) )) ;
            arrayList10kAverageGetTime += tester.testGet(tested10kArrayList, randomIndex);
            linkedList10kAverageGetTime += tester.testGet(tested10kLinkedList, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested100kArrayList.size()+1) )) ;
            arrayList100kAverageGetTime += tester.testGet(tested100kArrayList, randomIndex);
            linkedList100kAverageGetTime += tester.testGet(tested100kLinkedList, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested1000kArrayList.size()+1) )) ;
            arrayList1000kAverageGetTime += tester.testGet(tested1000kArrayList, randomIndex);
            linkedList1000kAverageGetTime += tester.testGet(tested1000kLinkedList, randomIndex);
        }
        testResults10K.put(ARRAYLIST_GET_TEST_NAME, arrayList10kAverageGetTime / MEASUREMENTS_NUMBER);
        testResults100K.put(ARRAYLIST_GET_TEST_NAME, arrayList100kAverageGetTime/ MEASUREMENTS_NUMBER);
        testResults1000K.put(ARRAYLIST_GET_TEST_NAME, arrayList1000kAverageGetTime/ MEASUREMENTS_NUMBER);

        testResults10K.put(LINKEDLIST_GET_TEST_NAME, linkedList10kAverageGetTime/ MEASUREMENTS_NUMBER);
        testResults100K.put(LINKEDLIST_GET_TEST_NAME, linkedList100kAverageGetTime/ MEASUREMENTS_NUMBER);
        testResults1000K.put(LINKEDLIST_GET_TEST_NAME, linkedList1000kAverageGetTime/ MEASUREMENTS_NUMBER);
    }

    private static void testRemove() {
        for (int i = 0; i <= MEASUREMENTS_NUMBER; i++) {
            int randomIndex = (int) (Math.floor(Math.random() * (tested10kHashSet.size() + 1)));
            hashSet10kAverageRemoveTime += tester.testRemove(tested10kHashSet, randomIndex);
            randomIndex = (int) (Math.floor(Math.random() * (tested100kHashSet.size() + 1)));
            hashSet100kAverageRemoveTime += tester.testRemove(tested100kHashSet, randomIndex);
            randomIndex = (int) (Math.floor(Math.random() * (tested1000kHashSet.size() + 1)));
            hashSet1000kAverageRemoveTime += tester.testRemove(tested1000kHashSet, randomIndex);

            randomIndex = (int) (Math.floor(Math.random() * (tested10kTreeSet.size() + 1)));
            treeSet10kAverageRemoveTime += tester.testRemove(tested10kTreeSet, randomIndex);
            randomIndex = (int) (Math.floor(Math.random() * (tested100kTreeSet.size() + 1)));
            treeSet100kAverageRemoveTime += tester.testRemove(tested100kTreeSet, randomIndex);
            randomIndex = (int) (Math.floor(Math.random() * (tested1000kTreeSet.size() + 1)));
            treeSet1000kAverageRemoveTime += tester.testRemove(tested1000kTreeSet, randomIndex);
        }

        testResults10K.put(HASHSET_REMOVE_TEST_NAME, hashSet10kAverageRemoveTime / MEASUREMENTS_NUMBER);
        testResults100K.put(HASHSET_REMOVE_TEST_NAME, hashSet100kAverageRemoveTime / MEASUREMENTS_NUMBER);
        testResults1000K.put(HASHSET_REMOVE_TEST_NAME, hashSet1000kAverageRemoveTime / MEASUREMENTS_NUMBER);

        testResults10K.put(TREESET_REMOVE_TEST_NAME, treeSet10kAverageRemoveTime / MEASUREMENTS_NUMBER);
        testResults100K.put(TREESET_REMOVE_TEST_NAME, treeSet100kAverageRemoveTime / MEASUREMENTS_NUMBER);
        testResults1000K.put(TREESET_REMOVE_TEST_NAME, treeSet1000kAverageRemoveTime / MEASUREMENTS_NUMBER);
    }

    private static void testContains()  {
        for(int i = 0; i <= MEASUREMENTS_NUMBER; i++)   {
            int randomIndex = (int) (Math.floor( Math.random() * (tested10kArrayList.size()+1) )) ;
            arrayList10kAverageContainsTime += tester.testContains(tested10kArrayList, randomIndex);
            linkedList10kAverageContainsTime += tester.testContains(tested10kLinkedList, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested100kArrayList.size()+1) )) ;
            arrayList100kAverageContainsTime += tester.testContains(tested100kArrayList, randomIndex);
            linkedList100kAverageContainsTime += tester.testContains(tested100kLinkedList, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested1000kArrayList.size()+1) )) ;
            arrayList1000kAverageContainsTime += tester.testContains(tested1000kArrayList, randomIndex);
            linkedList1000kAverageContainsTime += tester.testContains(tested1000kLinkedList, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested10kHashSet.size()+1) )) ;
            hashSet10kAverageContainsTime += tester.testContains(tested10kHashSet, randomIndex);
            randomIndex = (int) (Math.floor( Math.random() * (tested100kHashSet.size()+1) )) ;
            hashSet100kAverageContainsTime += tester.testContains(tested100kHashSet, randomIndex);
            randomIndex = (int) (Math.floor( Math.random() * (tested1000kHashSet.size()+1) )) ;
            hashSet1000kAverageContainsTime += tester.testContains(tested1000kHashSet, randomIndex);

            randomIndex = (int) (Math.floor( Math.random() * (tested10kTreeSet.size()+1) )) ;
            treeSet10kAverageContainsTime += tester.testContains(tested10kTreeSet, randomIndex);
            randomIndex = (int) (Math.floor( Math.random() * (tested100kTreeSet.size()+1) )) ;
            treeSet100kAverageContainsTime += tester.testContains(tested100kTreeSet, randomIndex);
            randomIndex = (int) (Math.floor( Math.random() * (tested1000kTreeSet.size()+1) )) ;
            treeSet1000kAverageContainsTime += tester.testContains(tested1000kTreeSet, randomIndex);
        }
        testResults10K.put(ARRAYLIST_CONTAINS_TEST_NAME, arrayList10kAverageContainsTime / MEASUREMENTS_NUMBER);
        testResults100K.put(ARRAYLIST_CONTAINS_TEST_NAME, arrayList100kAverageContainsTime/ MEASUREMENTS_NUMBER);
        testResults1000K.put(ARRAYLIST_CONTAINS_TEST_NAME, arrayList1000kAverageContainsTime/ MEASUREMENTS_NUMBER);

        testResults10K.put(LINKEDLIST_CONTAINS_TEST_NAME, linkedList10kAverageContainsTime/ MEASUREMENTS_NUMBER);
        testResults100K.put(LINKEDLIST_CONTAINS_TEST_NAME, linkedList100kAverageContainsTime/ MEASUREMENTS_NUMBER);
        testResults1000K.put(LINKEDLIST_CONTAINS_TEST_NAME, linkedList1000kAverageContainsTime/ MEASUREMENTS_NUMBER);

        testResults10K.put(HASHSET_CONTAINS_TEST_NAME, hashSet10kAverageContainsTime / MEASUREMENTS_NUMBER);
        testResults100K.put(HASHSET_CONTAINS_TEST_NAME, hashSet100kAverageContainsTime / MEASUREMENTS_NUMBER);
        testResults1000K.put(HASHSET_CONTAINS_TEST_NAME, hashSet1000kAverageContainsTime/ MEASUREMENTS_NUMBER);

        testResults10K.put(TREESET_CONTAINS_TEST_NAME, treeSet10kAverageContainsTime/ MEASUREMENTS_NUMBER);
        testResults100K.put(TREESET_CONTAINS_TEST_NAME, treeSet100kAverageContainsTime/ MEASUREMENTS_NUMBER);
        testResults1000K.put(TREESET_CONTAINS_TEST_NAME, treeSet1000kAverageContainsTime/ MEASUREMENTS_NUMBER);
    }

    private static void testIteratorAdd() {
        int randomIndex = (int) (Math.floor( Math.random() * (tested10kTreeSet.size()+1) )) ;
        testResults10K.put(ARRAYLIST_ITERATOR_ADD_TEST_NAME, tester.testIteratorAdd(tested10kArrayList,randomIndex,MEASUREMENTS_NUMBER ));
        testResults10K.put(LINKEDLIST_ITERATOR_ADD_TEST_NAME, tester.testIteratorAdd(tested10kLinkedList,randomIndex,MEASUREMENTS_NUMBER ));
        testResults100K.put(ARRAYLIST_ITERATOR_ADD_TEST_NAME, tester.testIteratorAdd(tested100kArrayList,randomIndex,MEASUREMENTS_NUMBER ));
        testResults100K.put(LINKEDLIST_ITERATOR_ADD_TEST_NAME, tester.testIteratorAdd(tested100kLinkedList,randomIndex,MEASUREMENTS_NUMBER ));
        testResults1000K.put(ARRAYLIST_ITERATOR_ADD_TEST_NAME, tester.testIteratorAdd(tested1000kArrayList,randomIndex,MEASUREMENTS_NUMBER ));
        testResults1000K.put(LINKEDLIST_ITERATOR_ADD_TEST_NAME, tester.testIteratorAdd(tested1000kLinkedList,randomIndex,MEASUREMENTS_NUMBER ));
    }

    private static void testIteratorRemove() {

        testResults10K.put(ARRAYLIST_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested10kArrayList,MEASUREMENTS_NUMBER ));
        testResults100K.put(ARRAYLIST_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested100kArrayList,MEASUREMENTS_NUMBER ));
        testResults1000K.put(ARRAYLIST_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested1000kArrayList,MEASUREMENTS_NUMBER ));

        testResults10K.put(LINKEDLIST_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested10kLinkedList,MEASUREMENTS_NUMBER ));
        testResults100K.put(LINKEDLIST_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested100kLinkedList,MEASUREMENTS_NUMBER ));
        testResults1000K.put(LINKEDLIST_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested1000kLinkedList,MEASUREMENTS_NUMBER ));

        testResults10K.put(HASHSET_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested10kHashSet,MEASUREMENTS_NUMBER ));
        testResults100K.put(HASHSET_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested100kHashSet,MEASUREMENTS_NUMBER ));
        testResults1000K.put(HASHSET_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested1000kHashSet,MEASUREMENTS_NUMBER ));

        testResults10K.put(TREESET_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested10kTreeSet,MEASUREMENTS_NUMBER ));
        testResults100K.put(TREESET_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested100kTreeSet,MEASUREMENTS_NUMBER ));
        testResults1000K.put(TREESET_ITERATOR_REMOVE_TEST_NAME, tester.testIteratorRemove(tested1000kTreeSet,MEASUREMENTS_NUMBER ));

    }


    private static void showResults() {
        resultWindow10K = new GraphicResults("10K Collection operation time complexity test results",FIRST_WINDOW_X_COORDINATE, FIRST_WINDOW_Y_COORDINATE,WINDOW_DEFAULT_HEIGHT, testResults10K);
        resultWindow100K = new GraphicResults("100K Collection operation time complexity test results",FIRST_WINDOW_X_COORDINATE,resultWindow10K.getY() + resultWindow10K.getHeight()  + WINDOWS_GAP, WINDOW_DEFAULT_HEIGHT, testResults100K);
        resultWindow1000K = new GraphicResults("1000K Collection operation time complexity test results", FIRST_WINDOW_X_COORDINATE,resultWindow100K.getY() +resultWindow100K.getHeight() +  + WINDOWS_GAP,WINDOW_DEFAULT_HEIGHT, testResults1000K);
    }

}
