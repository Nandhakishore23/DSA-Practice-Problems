import java.io.*;
import java.util.*;

public class rowWithMax1s{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().Max1s(arr);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
class Solution {
    public int Max1s(int arr[][]) {
        int maxRow = -1;
        int r = arr.length;
        int c = arr[0].length;
        int row = 0;
        int col = c -1;
        while(row<r && col>=0){
            if(arr[row][col] != 1){
                row++;
            }
            else{
                maxRow = row;
                col--;
            }
        }
        return maxRow;
    }
}