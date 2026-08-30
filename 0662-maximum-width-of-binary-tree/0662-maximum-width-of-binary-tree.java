import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Long>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0L));

        long maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            long first = queue.peek().getValue();
            long last = first;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> current = queue.poll();

                TreeNode node = current.getKey();
                long index = current.getValue();

                last = index;

                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return (int) maxWidth;
    }
}