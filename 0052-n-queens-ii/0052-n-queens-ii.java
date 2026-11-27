class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];

        solve(0, n, columns, diagonal1, diagonal2);

        return count;
    }

    private void solve(int row, int n, boolean[] columns,
                       boolean[] diagonal1, boolean[] diagonal2) {

        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (columns[col] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            columns[col] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            solve(row + 1, n, columns, diagonal1, diagonal2);

            columns[col] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}