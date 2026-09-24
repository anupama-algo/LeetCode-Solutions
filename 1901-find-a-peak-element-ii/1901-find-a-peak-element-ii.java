class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0;
        int right = cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int maxRow = 0;

            for (int row = 1; row < rows; row++) {
                if (mat[row][mid] > mat[maxRow][mid]) {
                    maxRow = row;
                }
            }

            int leftValue = mid > 0 ? mat[maxRow][mid - 1] : -1;
            int rightValue = mid < cols - 1 ? mat[maxRow][mid + 1] : -1;

            if (mat[maxRow][mid] > leftValue &&
                mat[maxRow][mid] > rightValue) {
                return new int[]{maxRow, mid};
            }

            if (leftValue > mat[maxRow][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}