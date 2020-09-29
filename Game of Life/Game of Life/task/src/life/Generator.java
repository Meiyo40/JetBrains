package life;

import java.util.Random;

public class Generator {
    public static int[][] create(int N, long seed) {
        Random rand = new Random(seed);
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = rand.nextBoolean() ? 1 : 0;
            }
        }
        return matrix;
    }

    public static int[][] generate(int[][] state) {
        int L = state.length;
        int[][] result = new int[L][L];
        for (int i = 0; i < L; i++) {
            int N = i-1 == -1 ? L-1 : i-1, S = i+1 == L ? 0 : i+1;
            for (int j = 0; j < L; j++) {
                int E = j+1 == L ? 0 : j+1, W = j-1 == -1 ? L-1 : j-1;
                int sum = state[N][W] + state[N][j] + state[N][E] + state[i][W] + state[i][E] + state[S][W] + state[S][j] + state[S][E];
                int value = sum == 3 || (state[i][j] == 1 && sum == 2) ? 1 : 0;
                //System.out.printf("(%d, %d): SUM = %d, VALUE = %d, NEW_VALUE = %d\n", i, j, sum, state[i][j], value);
                result[i][j] = value;
            }
        }
        return result;
    }
}