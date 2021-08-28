package main.java.coding.graph;

import java.util.*;

//addVertex
//removeVertex
//addEdge
//removeEdge
//https://www.geeksforgeeks.org/union-find/
public class GraphDemo {

    static Map<Integer, List<Integer>>  map =  new HashMap<>();

    public static void main(String[] args) {

        addVertex(1);
        addVertex(2);
        addVertex(3);
        addVertex(4);
        addVertex(5);
        System.out.println(map);
        removeVertex(10);
        System.out.println(map);

        addEdge(1, 2);
        addEdge(1, 4);
        addEdge(2, 3);
        addEdge(4, 3);
        addEdge(2, 5);
        addEdge(4, 5);
        System.out.println(map);

        System.out.println(depthFirstTraversal(1));

        Set<Integer> set = new HashSet<>();
        depthFirstRecursive(1, set);
        System.out.println(set);
        System.out.println(breadthFirstTraversal(1));

       // System.out.println(" is cycle graph: "  + isCycle());
        removeEdge(2,5);
        removeEdge(1,4);
        System.out.println(" is cycle graph: "  + isCycle());
//        System.out.println(map);
    }

    public static void addVertex(Integer vertex){
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    public static void removeVertex(Integer vertex){
        map.values().stream().forEach(l -> l.remove(vertex));
        map.remove(vertex);
    }

    //addEdge
    public static void addEdge(Integer vertex1, Integer vertex2){
        map.get(vertex1).add(vertex2);
        map.get(vertex2).add(vertex1);
    }

    public static void removeEdge(Integer vertex1, Integer vertex2){
        map.get(vertex1).remove(vertex2);
        map.get(vertex2).remove(vertex1);
    }

    public static Set<Integer> depthFirstTraversal(Integer root){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(root);
        while (!stack.isEmpty()){
            Integer v = stack.pop();
            visited.add(v);
            for (Integer adjv: map.get(v)) {
                if(!visited.contains(adjv)) {
                    stack.add(adjv);
                }
            }
        }
        return visited;
    }

    public static void depthFirstRecursive(Integer root, Set<Integer> visited){
        if(visited.contains(root)) return;
        visited.add(root);
        for (Integer adjv: map.get(root)) {
            depthFirstRecursive(adjv, visited);
        }
    }

    public static Set<Integer> breadthFirstTraversal(Integer root){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.add(root);
        while (!queue.isEmpty()){
            Integer v = queue.poll();
            set.add(v);
            for ( Integer s: map.get(v)) {
                if(!set.contains(s)){
                    queue.add(s);
                }
            }
        }

        return set;
    }

    public static boolean isCycle( ){
        int [] parent = new int[1000];

        for (Integer v: map.keySet()) {
            parent[v] = v;
        }

        Set<Pair<Integer,Integer>> set = new HashSet<>();
        for(Integer v : map.keySet()){
            int psrc = find(v, parent);
            for ( Integer vdes: map.get(v)) {
                if (set.contains(new Pair<>(v,vdes))) continue; ;
                int pdes = find(vdes, parent);
                if(pdes==psrc) return true;
                parent[v] = vdes;// union
                set.add(new Pair<>(v,vdes));
                set.add(new Pair<>(vdes,v));
            }
        }
       return false;
    }

    private static int find( int v, int [] parent){
        if(v==parent[v]) return v;
        return find(parent[v], parent);
    }

    private static class Pair<T, T1> implements Comparable<Pair>{
        public T x;
        public T1 y;

        public Pair(T x, T1 y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair pair){
            return this.x == pair.x && this.y== pair.y ? 0 : 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(x, pair.x) && Objects.equals(y, pair.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
