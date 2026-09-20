import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];

                if (value == '.') {
                    continue;
                }

                if (!seen.add(value + " in row " + i) ||
                    !seen.add(value + " in column " + j) ||
                    !seen.add(value + " in box " + i / 3 + "-" + j / 3)) {
                    return false;
                }
            }
        }

        return true;
    }
}