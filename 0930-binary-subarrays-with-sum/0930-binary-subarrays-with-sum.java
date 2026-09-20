import java.util.HashMap;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int answer = 0;

        for (int num : nums) {
            sum += num;

            answer += map.getOrDefault(sum - goal, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }
}