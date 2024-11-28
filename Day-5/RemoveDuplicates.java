import java.io.*;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Solution ob = new Solution();
            int ans = ob.remove_duplicate(arr);
            for (int i = 0; i < ans; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();    
System.out.println("~");
}
        sc.close();
    }
}

class Solution {
    public int remove_duplicate(List<Integer> arr) {
        if (arr.size() == 0) return 0;
        int j = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (!arr.get(i).equals(arr.get(j))) {
                j++;
                arr.set(j, arr.get(i));
            }
        }
        return j + 1;
    }
}
