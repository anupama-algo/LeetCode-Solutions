class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int answer = 0;

        for (int num : nums) {
            sum += num;

            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k;
            }

            answer += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return answer;
    }
}