
import java.util.Arrays;

class Solution {
    int[][][] dp;
    int rows, cols;

    public int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        dp = new int[rows][cols][cols];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return solve(grid, 0, 0, cols - 1);
    }

    private int solve(int[][] grid, int row, int c1, int c2) {
        if (c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols) {
            return -1000000000;
        }

        if (dp[row][c1][c2] != -1) {
            return dp[row][c1][c2];
        }

        int cherries = grid[row][c1];

        if (c1 != c2) {
            cherries += grid[row][c2];
        }

        if (row == rows - 1) {
            return dp[row][c1][c2] = cherries;
        }

        int maxNext = 0;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                maxNext = Math.max(
                    maxNext,
                    solve(grid, row + 1, c1 + d1, c2 + d2)
                );
            }
        }

        return dp[row][c1][c2] = cherries + maxNext;
    }
}
