import java.util.*;
public class Anagrams{
	/*public static boolean checkAnagram(String f, String s){
		if(f.length() != s.length()){
			return false;
		}
		char[] arr1 = f.toCharArray();
		char[] arr2 = s.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1,arr2);
	}*/
	public static boolean checkAnagram(String s1, String s2){
		HashMap<Character, Integer> charCount = new HashMap<>();
        	for (char ch : s1.toCharArray()) 
            		charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        	for (char ch : s2.toCharArray()) 
            		charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
        	for (var pair : charCount.entrySet()) {
            		if (pair.getValue() != 0) {
                		return false;
            		}
        	}
        	return true;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First String : ");
		String f = sc.nextLine();
		System.out.println("Enter Second String : ");
		String s = sc.nextLine();
		boolean res = checkAnagram(f,s);
		System.out.println(res ? "true" : "false");
		sc.close();
	}
}