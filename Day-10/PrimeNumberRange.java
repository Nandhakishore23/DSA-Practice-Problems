import java.io.*;
import java.util.*;
class PrimeNumberRange {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.primeRange(M, N);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
       	System.out.println("~");
	}
    }
}
class Solution {
    ArrayList<Integer> primeRange(int M, int N) {
        ArrayList<Integer> al = new ArrayList<>();
        boolean arr[] = new boolean[N + 1];
        arr[1] = true;
        for (int i = 2; i<=Math.sqrt(N); i++) {
            if (!arr[i]) { 
                for (int j = i * i; j <= N; j += i) {
                    arr[j] = true; 
                }
            }
        }
        for (int i = M; i <= N; i++) {
            if (!arr[i]) {
                al.add(i);
            }
        }
        return al;
    }
}