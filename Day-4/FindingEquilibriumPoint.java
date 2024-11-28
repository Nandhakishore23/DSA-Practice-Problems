import java.io.*;
import java.util.*;
class FindingEquilibriumPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
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
            Solution obj = new Solution();
            System.out.println(obj.equilibriumPoint(arr));
            System.out.println("~");
        }
    }
}

class Solution {
    public static int equilibriumPoint(int arr[]) {
        int n = arr.length;
        if(n == 1) return 1;
        long total = 0;
        for(int num : arr){
            total += num;
        }
        long leftSum = 0;
        for(int i=0 ; i<n;i++){
            long rightSum = total - leftSum - arr[i];
            if(rightSum == leftSum){
                return i+1;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
