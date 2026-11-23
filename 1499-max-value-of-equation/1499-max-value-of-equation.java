
import java.util.*;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;

        for (int j = 0; j < points.length; j++) {
            int xj = points[j][0];
            int yj = points[j][1];

            // Remove points outside the allowed distance
            while (!deque.isEmpty() &&
                   xj - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }

            // Calculate the maximum equation value
            if (!deque.isEmpty()) {
                int i = deque.peekFirst();

                ans = Math.max(ans,
                    points[i][1] - points[i][0] + yj + xj);
            }

            // Maintain decreasing order of (y - x)
            while (!deque.isEmpty() &&
                   points[deque.peekLast()][1] -
                   points[deque.peekLast()][0] <= yj - xj) {
                deque.pollLast();
            }

            deque.offerLast(j);
        }

        return ans;
    }
}
