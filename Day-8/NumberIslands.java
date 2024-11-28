import java.util.Scanner;
class NumberIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    c++;
                    dfs(grid, i, j);
                }
            }
        }
        return c;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';  // mark as visited
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = sc.nextInt();
        System.out.println("Enter the grid (0 for water, 1 for land):");
        char[][] grid = new char[rows][cols];
        sc.nextLine(); 
        for (int i = 0; i < rows; i++) {
            String row = sc.nextLine();
            grid[i] = row.toCharArray();
        }
        NumberIslands solution = new NumberIslands();
        int numberOfIslands = solution.numIslands(grid);
        System.out.println("Number of islands: " + numberOfIslands);
        sc.close();
    }
}
