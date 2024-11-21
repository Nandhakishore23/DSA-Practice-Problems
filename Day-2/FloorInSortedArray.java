import java.util.*;
 
class FloorInSortedArray {
    static int floorSearch(int arr[], int x)
    {
	int n = arr.length;
        if (x >= arr[n - 1])
            return n - 1;
        if (x < arr[0])
            return -1;
        for (int i = 1; i < n; i++)
            if (arr[i] > x)
                return (i - 1);
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Elements in the array: ");
	String input = sc.nextLine();
	System.out.println("Enter the value of x: ");
	int x = sc.nextInt();
	String[] inputStrings = input.split(" ");
	int[] nums = new int[inputStrings.length];
	for(int i=0;i<inputStrings.length;i++){
		nums[i] = Integer.parseInt(inputStrings[i]);
	}
	int res = floorSearch(nums,x);
	System.out.println("Floor "+ x + " in array is " + res);
	sc.close();
    }
}