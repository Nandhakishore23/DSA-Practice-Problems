import java.io.*;
import java.util.*;
import java.util.HashMap;
class Solution {
    static List<Integer> kLargest(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            result.add(arr[i]);
        }
        return result;
    }
}

public class Klargest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            ArrayList<Integer> array = new ArrayList<>();
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int k = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            List<Integer> ans = ob.kLargest(arr, k);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); 
            System.out.println("~");
        }
    }
}