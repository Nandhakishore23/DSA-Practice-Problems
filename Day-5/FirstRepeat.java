import java.io.*;
import java.util.*;
class FirstRepeat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); 
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            ArrayList<Long> array = new ArrayList<>();
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }
            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int)i;
            Solution obj = new Solution();
            System.out.println(obj.firstRepeated(arr));
	System.out.println("~");
	}
    }
}

class Solution {
    public static int firstRepeated(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minI = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                minI = Math.min(minI, map.get(arr[i]));
            }
            else{
                map.put(arr[i],i);
            }
        }
        return (minI == Integer.MAX_VALUE) ? -1 : minI + 1;
    }
}
