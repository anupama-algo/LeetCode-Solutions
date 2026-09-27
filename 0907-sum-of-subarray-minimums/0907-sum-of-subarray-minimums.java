import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long answer = 0;
        long mod = 1_000_000_007;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int current = i == n ? 0 : arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] > current) {
                int index = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long leftCount = index - left;
                long rightCount = right - index;

                answer = (answer + arr[index] * leftCount % mod * rightCount) % mod;
            }

            stack.push(i);
        }

        return (int) answer;
    }
}