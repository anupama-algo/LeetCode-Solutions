class Solution {

    private static class Node {
        Node[] children = new Node[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        Node root = new Node();

        for (String word : words) {
            insert(root, word);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root, result);
            }
        }

        return result;
    }

    private void insert(Node root, String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new Node();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    private void dfs(char[][] board, int row, int col,
                     Node node, List<String> result) {

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];

        if (ch == '#') {
            return;
        }

        Node next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, next, result);
        dfs(board, row - 1, col, next, result);
        dfs(board, row, col + 1, next, result);
        dfs(board, row, col - 1, next, result);

        board[row][col] = ch;
    }
}