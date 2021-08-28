package main.java.coding.AOA;

public class test {

    public static void main(String[] args) {
       int i =  all(6, 0);
        System.out.println(i);
    }

    static int all(int n, int sum){
        if(n==0) return 1;
        sum += all(n-2, sum);
        if(n>4)
            sum += all(n-4, sum);
        return sum;
    }
}
