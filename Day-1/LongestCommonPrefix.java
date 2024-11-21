import java.util.*;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "-1";
        }
        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[arr.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        if (i == 0) {
            return "-1";
        }
        return first.substring(0, i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        System.out.println("Enter the strings: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        String res = longestCommonPrefix(arr);
        System.out.println("Longest Common Prefix: " + res);
        sc.close();
    }
}
