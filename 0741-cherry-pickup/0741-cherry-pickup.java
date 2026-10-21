
import java.util.Arrays;

class Solution {
    int[][][] dp;
    int n;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new int[n][n][n];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, solve(grid, 0, 0, 0));
    }

    private int solve(int[][] grid, int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            c2 < 0 || grid[r1][c1] == -1 ||
            grid[r2][c2] == -1) {
            return -1000000;
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != Integer.MIN_VALUE) {
            return dp[r1][c1][r2];
        }

        int cherries = grid[r1][c1];

        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }

        int best = Math.max(
            Math.max(
                solve(grid, r1 + 1, c1, r2 + 1),
                solve(grid, r1 + 1, c1, r2)
            ),
            Math.max(
                solve(grid, r1, c1 + 1, r2 + 1),
                solve(grid, r1, c1 + 1, r2)
            )
        );

        return dp[r1][c1][r2] = cherries + best;
    }
}
