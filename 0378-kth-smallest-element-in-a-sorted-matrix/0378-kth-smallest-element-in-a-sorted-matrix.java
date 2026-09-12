class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int row = 0; row < Math.min(n, k); row++) {
            minHeap.offer(new int[]{matrix[row][0], row, 0});
        }

        for (int count = 0; count < k - 1; count++) {
            int[] current = minHeap.poll();

            int row = current[1];
            int col = current[2];

            if (col + 1 < n) {
                minHeap.offer(
                    new int[]{matrix[row][col + 1], row, col + 1}
                );
            }
        }

        return minHeap.peek()[0];
    }
}