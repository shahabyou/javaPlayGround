package main.java.allJava;

import java.util.*;
import java.util.stream.Collectors;

public class AllJava {

    public static void main(String[] args) {

        PriorityQueue<Integer> list = new PriorityQueue<>(
                (a,b) -> a-b
        );

        for (int i = 1; i < 9; i++) {
            list.add(i);
        }
        System.out.println(list);
        while (!list.isEmpty()){
            System.out.println(list.poll());
        }
 //      string();
//        linkedlist();
        //map();
//        collection();
//        arrayCopyfun();
 //       compare();
        //convertArray(); // TODO
       // heap();
    }
    public static void string(){
        System.out.println("==== string ===");
        String str = "This is String Test";

        for (Character c: str.toCharArray()) {
            System.out.println(c);
        }

        System.out.println(str.substring(0,4));// not inclusive

        System.out.println( (new StringBuilder(str)).reverse());

    }
    public static void linkedlist(){
        System.out.println("======== List =======");
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i < 9; i++) {
            list.add(i);
        }

        System.out.println(list);

        list.addFirst(9);
        list.addLast(0);

        System.out.println(list);

        System.out.println("get 0 index"+list.get(0));
        System.out.println("first item"+list.getFirst());
        System.out.println("last item"+list.getLast());
        System.out.println("index of 5"+list.indexOf(5));

        list.sort(Integer::compareTo);
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        list.addFirst(9);
        list.addLast(0);
        list.sort((a,b)-> (a>b) ? -1 : 1);
        System.out.println(list);

        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }
    public static void map() {
        System.out.println("======== map =======");

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            map.put(i,i);
        }
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i,i);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println( map.getOrDefault(i,i)); // it is not persist
        }
        System.out.println(map);

        Set<Integer> keys = map.keySet();
        System.out.println(keys);

        List<Integer> listKey = new ArrayList<>( map.keySet());
        System.out.println(listKey);

        List<Integer> list = new ArrayList<>( map.values());
        System.out.println(list);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        System.out.println(entries);

        Map<Integer, Integer> map1 = new HashMap<>(map);
        map.clear();
        map1.remove(9);
        System.out.println(map);
        System.out.println(map1);

        for (Map.Entry<Integer,Integer> entry: map.entrySet()
             ) {
            System.out.println(entry.getValue());
        }
    }
    public static void collection(){

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.peek();
        stack.pop();
        stack.size();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(15);
        System.out.println(queue);
        // Printing the top element of
        // the LinkedList
        System.out.println(queue.peek());
        // Printing the top element and removing it
        // from the LinkedList container
        System.out.println(queue.poll());
        // Printing the top element again
        System.out.println(queue.peek());


        Queue<Integer> pqueue = new PriorityQueue<>();
        pqueue.add(10);
        pqueue.add(20);
        pqueue.add(15);
        System.out.println(pqueue);
        // Printing the top element of
        // the LinkedList
        System.out.println(pqueue.peek());
        // Printing the top element and removing it
        // from the LinkedList container
        System.out.println(pqueue.poll());
        // Printing the top element again
        System.out.println(pqueue.peek());
    }
    public static void arrayCopyfun(){

        int [] arr = new int[]{1,3,2,5,4,6};
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0, 3)));

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0, arr.length)));

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0, arr.length+1))); // fill right with 0

        System.out.println(Arrays.toString(Arrays.copyOf(arr, arr.length)));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println( Arrays.binarySearch(arr, 2));// return index;

        System.arraycopy(arr,0,arr,arr.length/2, arr.length/2); //ArrayIndexOutOfBoundsException
        System.out.println(Arrays.toString(arr));

        Arrays.fill(arr,3,arr.length,0);
        System.out.println(Arrays.toString(arr));

        Arrays.fill(arr,1);
        System.out.println(Arrays.toString(arr));

    }

    public static void compare(){

        int [][] arr = new int[][]{{1,3},{15,18},{2,6},{8,10}};
        System.out.println(Arrays.deepToString(arr));

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        System.out.println(Arrays.deepToString(arr));

        //java 8
        arr = new int[][]{{1,3},{15,18},{2,6},{8,10}};
        System.out.println(Arrays.deepToString(arr));
        Arrays.sort(arr, (int [] o1, int [] o2)-> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(arr));


        //java 8 better way
        arr = new int[][]{{1,3},{15,18},{2,6},{8,10}};
        System.out.println(Arrays.deepToString(arr));
        Arrays.sort(arr, (a,b)-> Integer.compare(a[0],b[0]));
        System.out.println(Arrays.deepToString(arr));
        }




        public static class Student implements Comparable{
            public String name;
            public int grad;
            public int score;

            public Student(String name, int grad, int score) {
                this.name = name;
                this.grad = grad;
                this.score = score;
            }


            @Override
            public int compareTo(Object o) {
                return Integer.compare(this.grad,((Student)o).grad);
            }

            @Override
            public String toString() {
                return "Student{" +
                        "name='" + name + '\'' +
                        ", grad=" + grad +
                        ", score=" + score +
                        '}';
            }
        }
}
