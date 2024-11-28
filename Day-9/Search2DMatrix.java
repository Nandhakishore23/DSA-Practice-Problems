import java.util.Scanner;
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        System.out.println("Enter the elements of the matrix row by row:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();
        Search2DMatrix sol = new Search2DMatrix();
        boolean found = sol.searchMatrix(matrix, target);
        System.out.println("Is the target present in the matrix? " + (found ? "Yes" : "No"));
        sc.close();
    }
}
