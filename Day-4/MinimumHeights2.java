import java.io.*;
import java.util.*;

public class MinimumHeights2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}


class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr); 
        int ans = arr[n - 1] - arr[0];
        int mi = arr[0] + k;
        int ma = arr[n - 1] - k;
        for (int i = 0; i < n - 1; i++) {
            int curMax = Math.max(ma, arr[i] + k);
            int curMin = Math.min(mi, arr[i + 1] - k);
            if (curMin < 0) continue;
            ans = Math.min(ans, curMax - curMin);
        }
        return ans;
    }
}
