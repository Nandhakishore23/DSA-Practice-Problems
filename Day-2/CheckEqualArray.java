import java.util.*;
public class CheckEqualArray{
	public static boolean check(int[] arr1,int[] arr2){
		int m = arr1.length;
		int n = arr2.length;
		if(m!=n) return false;
		Map<Integer,Integer> map = new HashMap<>();
		int c=0;
		for(int i=0;i<n;i++){
			if(map.get(arr1[i]) == null) {map.put(arr1[i],1);}
			else{
				c= map.get(arr1[i]);
				c++;
				map.put(arr1[i],c);
			}
		}	
		for(int i=0;i<n;i++){
			if(!map.containsKey(arr2[i])){
				return false;
			}
			if(map.get(arr2[i])==0){
				return false;
			}
			c= map.get(arr2[i]);
			--c;
			map.put(arr2[i],c);
		}
		return true;
	} 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array 1 values : ");
		String input1 = sc.nextLine();
		String[] inputStrings1 = input1.split(" ");
		int[] arr1 = new int[inputStrings1.length];
		for(int i=0;i<inputStrings1.length;i++){
			arr1[i] = Integer.parseInt(inputStrings1[i]);
		}
		System.out.println("Enter the array 2 values : ");
		String input2 = sc.nextLine();
		String[] inputStrings2 = input2.split(" ");
		int[] arr2 = new int[inputStrings2.length];
		for(int i=0;i<inputStrings2.length;i++){
			arr2[i] = Integer.parseInt(inputStrings2[i]);
		}
		Boolean res = check(arr1,arr2);
		System.out.println(res);
		sc.close();
	}
}