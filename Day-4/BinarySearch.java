import java.io.*;
import java.util.*;
public class BinarySearch {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();
            String[] strNumbers = input.split(" ");
            int[] arr = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                arr[i] = Integer.parseInt(strNumbers[i]);
            }
            Solution ob = new Solution();
            int res = ob.binary(arr, k);
            System.out.println(res);
        
System.out.println("~");
}
        sc.close();
    }
}

class Solution {
    public int binary(int[] arr, int k) {
        int l =0; 
        int r = arr.length -1;
        int mid = (l + r)/ 2;
        while(l <= r){
            if(arr[mid] == k){
                return mid;
            }
            else if(arr[mid] > k){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
            mid = (l + r)/ 2;
        }
        return -1;
    }
}