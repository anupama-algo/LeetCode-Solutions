/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    void findPaths(TreeNode* node, int remainingSum, vector<int>& currentPath, vector<vector<int>>& allPaths) {
        if (!node) {
            return;
        }
        currentPath.push_back(node->val);

        if (!node->left && !node->right && node->val == remainingSum) {
            allPaths.push_back(currentPath);
        } else {
            findPaths(node->left, remainingSum - node->val, currentPath, allPaths);
            findPaths(node->right, remainingSum - node->val, currentPath, allPaths);
        }

        currentPath.pop_back();
    }

public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> allPaths;
        vector<int> currentPath;
        findPaths(root, targetSum, currentPath, allPaths);
        return allPaths;
    }
};