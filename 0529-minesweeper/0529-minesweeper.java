
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        dfs(board, r, c);
        return board;
    }

    private void dfs(char[][] board, int r, int c) {
        int m = board.length;
        int n = board[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n
                || board[r][c] != 'E') {
            return;
        }

        int mines = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nr = r + i;
                int nc = c + j;

                if (nr >= 0 && nc >= 0 && nr < m && nc < n
                        && board[nr][nc] == 'M') {
                    mines++;
                }
            }
        }

        if (mines > 0) {
            board[r][c] = (char) ('0' + mines);
            return;
        }

        board[r][c] = 'B';

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    dfs(board, r + i, c + j);
                }
            }
        }
    }
}
