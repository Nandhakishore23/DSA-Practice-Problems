import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray); 
            String sortedStr = new String(charArray); 
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        String[] strs = new String[n];
        System.out.println("Enter the strings: ");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        GroupAnagrams solution = new GroupAnagrams();
        List<List<String>> groupedAnagrams = solution.groupAnagrams(strs);
        System.out.println("Grouped Anagrams: ");
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
        sc.close();
    }
}
