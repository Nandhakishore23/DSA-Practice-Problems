import java.util.*;

class RatMazeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        
System.out.println("~");
}
    }
}


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> res = new ArrayList<>();
        int n = mat.length;
        if(mat[0][0] == 0 || mat[n-1][n-1] == 0){
            return res;
        }
        findPaths(mat,0,0,"",res,n);
        return res;
    }
    private void findPaths(int[][] mat, int x, int y, String path, ArrayList<String> res, int n){
        if(x == n-1 && y == n-1){
            res.add(path);
            return;
        }
        mat[x][y] = 0;
        if(isSafe(mat, x+1, y, n)){
            findPaths(mat, x+1, y, path + "D", res, n);
        }
        if(isSafe(mat, x, y-1, n)){
            findPaths(mat, x, y-1, path + "L", res, n);
        }
        if(isSafe(mat, x, y+1, n)){
            findPaths(mat, x, y+1, path + "R", res, n);
        }
        if(isSafe(mat, x-1, y, n)){
            findPaths(mat, x-1, y, path + "U", res, n);
        }
        mat[x][y] = 1;
    }
    private boolean isSafe(int[][] mat, int x, int y, int n){
        return x >= 0 && y >= 0 && x < n && y < n && mat[x][y] == 1;
    }
}