
import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int mod = 1000000007;

        int[] power = new int[n];
        power[0] = 1;

        for (int i = 1; i < n; i++) {
            power[i] = (int)((power[i - 1] * 2L) % mod);
        }

        int left = 0;
        int right = n - 1;
        int ans = 0;

        while (left <= right) {
            if ((long)nums[left] + nums[right] <= target) {
                ans = (int)((ans + (long)power[right - left]) % mod);
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
