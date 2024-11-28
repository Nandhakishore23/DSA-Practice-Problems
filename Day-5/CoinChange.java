import java.io.*;
import java.util.*;

class CoinChange {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
        }
    }
}


class Solution {
    public int count(int coins[], int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int num : coins){
            for(int j = num; j<=sum;j++){
                dp[j] += dp[j - num];
            }
        }
        return dp[sum];
    }
}