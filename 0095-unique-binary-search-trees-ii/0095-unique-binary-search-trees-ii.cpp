class Solution {
public:
    vector<TreeNode*> generateTrees(int n) {
        if (n == 0) return {};
        return buildTrees(1, n);
    }

    vector<TreeNode*> buildTrees(int start, int end) {
        if (start > end) return {nullptr};
        
        vector<TreeNode*> allTrees;
        for (int i = start; i <= end; i++) {
            vector<TreeNode*> leftSubtrees = buildTrees(start, i - 1);
            vector<TreeNode*> rightSubtrees = buildTrees(i + 1, end);

            for (TreeNode* left : leftSubtrees) {
                for (TreeNode* right : rightSubtrees) {
                    TreeNode* root = new TreeNode(i);
                    root->left = left;
                    root->right = right;
                    allTrees.push_back(root);
                }
            }
        }
        return allTrees;
    }
};