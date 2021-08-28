package main.java.allJava;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapDemo {



    public static void main(String[] args){

        // min heap Default
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(10);
        heap.add(90);
        heap.add(20);
        heap.add(40);

        for (Integer item : heap) {
            System.out.println(item);
        }

        while (!heap.isEmpty()){
//                System.out.println(heap.peek());
//                heap.remove();
            System.out.println(heap.poll());
        }

        // max heap
        heap = new PriorityQueue<>(Collections.reverseOrder());

        heap.add(10);
        heap.add(90);
        heap.add(20);
        heap.add(40);

        System.out.println(heap);

        while (!heap.isEmpty()){
//                System.out.println(heap.peek());
//                heap.remove();
            System.out.println(heap.poll());
        }

        PriorityQueue<AllJava.Student> students = new PriorityQueue<>(
                 (a,b) -> (a.grad + a.score ) - (b.grad + b.score)
        );

        students.add( new AllJava.Student("a", 10 , 10000));
        students.add(new AllJava.Student("d", 90 , 900));
        students.add(new AllJava.Student("b", 20 , 200));
        students.add(new AllJava.Student("c", 40 , 400));

        System.out.println(students);

        while (!students.isEmpty()){
//                System.out.println(heap.peek());
//                heap.remove();
            System.out.println(students.poll());
        }


        // min heap Default
        PriorityQueue<int []> heapPair = new PriorityQueue<>(
                (a,b) -> (b[0]+b[1]) - (a[0]+a[1])
        );

        for (int i = 0; i < 5; i++) {
            heapPair.add(new int[]{i,i});
        }

        while (!heapPair.isEmpty()){
//                System.out.println(heap.peek());
//                heap.remove();
            int [] a = heapPair.poll();
            System.out.println(a[0]+ " "+ a[1]);
        }


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
