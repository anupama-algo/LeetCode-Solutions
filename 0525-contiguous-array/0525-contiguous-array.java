import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int balance = 0;
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                balance--;
            } else {
                balance++;
            }

            if (map.containsKey(balance)) {
                answer = Math.max(answer, i - map.get(balance));
            } else {
                map.put(balance, i);
            }
        }

        return answer;
    }
}