class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);

        return dfs(root, 0L, targetSum, prefix);
    }

    private int dfs(TreeNode node, long currentSum,
                    int targetSum, Map<Long, Integer> prefix) {

        if (node == null) {
            return 0;
        }

        currentSum += node.val;

        int count = prefix.getOrDefault(
            currentSum - targetSum, 0
        );

        prefix.put(
            currentSum,
            prefix.getOrDefault(currentSum, 0) + 1
        );

        count += dfs(node.left, currentSum, targetSum, prefix);
        count += dfs(node.right, currentSum, targetSum, prefix);

        prefix.put(
            currentSum,
            prefix.get(currentSum) - 1
        );

        return count;
    }
}