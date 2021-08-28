package main.java.coding.dp.knapsack;

public class KnapsackProblem01 {
    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 1, 2, 3 };

        int W = 5;
        int N = val.length;

        System.out.println(knapSack(W, wt, val, N));
    }
    static int knapSack(int W, int wt[],
                           int val[], int n)
    {
        int dp[][] = new int[n+1][W+1];
        for (int i = 1; i <= n; i++) {
            for (int j=1; j <= W; j++){
                if(j< wt[i-1]){
                    dp[i][j]=  dp[i-1][j];
                }else{
                    dp[i][j]= Math.max( dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[n][W];
    }

}
