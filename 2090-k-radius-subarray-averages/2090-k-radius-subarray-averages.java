
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];

        java.util.Arrays.fill(ans, -1);

        int size = 2 * k + 1;

        if (size > n) {
            return ans;
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (i >= size) {
                sum -= nums[i - size];
            }

            if (i >= size - 1) {
                ans[i - k] = (int) (sum / size);
            }
        }

        return ans;
    }
}
