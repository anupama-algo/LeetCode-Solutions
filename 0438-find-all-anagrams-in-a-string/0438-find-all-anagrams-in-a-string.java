class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] count = new int[26];

        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int required = p.length();

        while (right < s.length()) {
            if (count[s.charAt(right) - 'a'] > 0) {
                required--;
            }

            count[s.charAt(right) - 'a']--;
            right++;

            if (right - left > p.length()) {
                if (count[s.charAt(left) - 'a'] >= 0) {
                    required++;
                }

                count[s.charAt(left) - 'a']++;
                left++;
            }

            if (required == 0) {
                result.add(left);
            }
        }

        return result;
    }
}