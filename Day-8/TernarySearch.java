import java.util.*;
import java.lang.*;
import java.io.*;
class TernarySearch{   
    public static void main(String args[])throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());  
        while(t-- > 0){
            String s[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);   
            int arr[] = new int[N]; 
            String st[] = read.readLine().trim().split("\\s+");
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.ternarySearch(arr, N, K));
System.out.println("~");
}
    }
}
class Solution{
    public static int ternarySearch(int arr[], int N, int K) {
        int left = 0, right = N - 1;
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            if (arr[mid1] == K) {
                return 1; 
            }
            if (arr[mid2] == K) {
                return 1; 
            }
            if (K < arr[mid1]) {
                right = mid1 - 1; 
            } else if (K > arr[mid2]) {
                left = mid2 + 1; 
            } else {
                left = mid1 + 1; 
                right = mid2 - 1;
            }
        }
        return -1; 
    }
}
