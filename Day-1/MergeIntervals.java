import java.util.*;
public class MergeIntervals {
    public static List<int[]> mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] cur = intervals[0];
        merged.add(cur);
        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                cur = intervals[i];
                merged.add(cur);
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of intervals:");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        System.out.println("Enter the intervals (start end):");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        List<int[]> res = mergeIntervals(intervals);        
	System.out.println("Merged intervals:");
        for (int[] interval : res) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
        sc.close();
    }
}
