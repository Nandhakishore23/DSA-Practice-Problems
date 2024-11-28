import java.util.Scanner;
class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string (s):");
        String s = sc.nextLine();
        System.out.println("Enter the second string (t):");
        String t = sc.nextLine();
        IsSubSequence solution = new IsSubSequence();
        boolean result = solution.isSubsequence(s, t);
        System.out.println("Is \"" + s + "\" a subsequence of \"" + t + "\"? " + result);
        sc.close();
    }
}
