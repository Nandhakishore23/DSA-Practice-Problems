import java.io.*;
import java.lang.*;
import java.util.*;

class UnionOfTwoArray{
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while (t-- > 0) {
            String line1 = read.readLine().trim();
            String[] numsStr1 = line1.split(" ");
            int[] a = new int[numsStr1.length];
            for (int i = 0; i < numsStr1.length; i++) {
                a[i] = Integer.parseInt(numsStr1[i]);
            }
            String line2 = read.readLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] b = new int[numsStr2.length];
            for (int i = 0; i < numsStr2.length; i++) {
                b[i] = Integer.parseInt(numsStr2[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.findUnion(a, b));
            System.out.println("~");
        }
    }
}

class Solution {
    public static int findUnion(int a[], int b[]) {
        HashSet<Integer> h1 = new HashSet<>();
        for(int i:a){
            h1.add(i);
        }
        for(int i:b){
            h1.add(i);
        }
        return h1.size();
    }
}