//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class findLongestConseqSubseq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int res = ob.findLong(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}


class Solution {
    public int findLong(int[] arr) {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);
        for (int i = 0; i < n; ++i) {
            if (!S.contains(arr[i] - 1)) {
                int j = arr[i];
                while (S.contains(j))
                    j++;
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }
}