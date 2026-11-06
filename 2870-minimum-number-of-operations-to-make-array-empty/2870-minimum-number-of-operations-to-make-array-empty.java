
import java.util.HashMap;

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            }

            ans += (count + 2) / 3;
        }

        return ans;
    }
}
