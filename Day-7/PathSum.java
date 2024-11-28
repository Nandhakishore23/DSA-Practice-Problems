import java.util.Scanner;
class PathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int j = 1; j < m; j++) {
            grid[j][0] += grid[j - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int m = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];
        System.out.println("Enter the grid elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        PathSum solution = new PathSum();
        int result = solution.minPathSum(grid);
        System.out.println("The minimum path sum is: " + result);
        scanner.close();
    }
}
