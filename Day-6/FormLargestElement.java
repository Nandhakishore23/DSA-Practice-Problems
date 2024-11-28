import java.io.*;
import java.util.*;

public class FormLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] numbers = input.split(" ");
            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }
            Solution ob = new Solution();
            String ans = ob.printLargest(arr);
            System.out.println(ans);
            System.out.println("~");
        }
        sc.close();
    }
}

class Solution {
    String printLargest(int[] arr) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            (x, y) -> (y + x).compareTo(x + y)
        );
        for (int num : arr) {
            maxHeap.add(String.valueOf(num));
        }
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            result.append(maxHeap.poll());
        }
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result.toString();
    }
}