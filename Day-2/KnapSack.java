public class KnapSack {
    static int knapSack(int W, int wt[], int val[], int N) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < N; i++) {
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }
        
        return dp[W];
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 5, 6};
        int[] wt = {2, 3, 4, 5};
        int W = 8;
        int N = val.length;
        System.out.println("Maximum value in Knapsack = " + knapSack(W, wt, val, N));
    }
}
