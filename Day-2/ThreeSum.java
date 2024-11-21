import java.util.*;

class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.print("Enter the number of elements in the array and the target sum (separated by space): ");
            int n = sc.nextInt();
            int X = sc.nextInt();
            int A[] = new int[n];
            System.out.print("Enter the elements of the array (separated by space): ");
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            boolean ans = ob.find3Numbers(A, n, X);
            System.out.println(ans ? "1 (Triplet found)" : "0 (No triplet found)");
        }
        sc.close();
    }
}

class Solution {
    public static boolean find3Numbers(int arr[], int n, int x) {
        Arrays.sort(arr); 
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int curr = arr[i] + arr[l] + arr[r];
                if (curr == x) {
                    return true;
                } else if (curr < x) {
                    l++; 
                } else {
                    r--; 
                }
            }
        }
        return false;
    }
}
