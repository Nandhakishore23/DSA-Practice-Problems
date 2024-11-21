import java.util.Arrays;
public class BooleanMatrix {
    public static void modifyMatrix(int mat[][]) {
        int M = mat.length;
        int N = mat[0].length;
        boolean[] rows = new boolean[M];
        boolean[] cols = new boolean[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            if (rows[i]) {
                for (int j = 0; j < N; j++) {
                    mat[i][j] = 1;
                }
            }
        }
        for (int j = 0; j < N; j++) {
            if (cols[j]) {
                for (int i = 0; i < M; i++) {
                    mat[i][j] = 1;
                }
            }
        }
    }
    public static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int mat[][] = {
            {1, 0},
            {0, 0}
        };
        System.out.println("Original Matrix:");
        printMatrix(mat);
        modifyMatrix(mat);
        System.out.println("Modified Matrix:");
        printMatrix(mat);
    }
}