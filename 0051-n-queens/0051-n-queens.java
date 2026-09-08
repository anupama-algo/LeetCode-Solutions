class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, board, result);
        return result;
    }

    private void backtrack(int row, char[][] board,
                            List<List<String>> result) {

        if (row == board.length) {
            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (!isSafe(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';

            backtrack(row + 1, board, result);

            board[row][col] = '.';
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 'Q') {
                return false;
            }
        }

        for (int r = row - 1, c = col - 1;
             r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        for (int r = row - 1, c = col + 1;
             r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }
}