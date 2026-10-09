import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int required = 1 << k;

        if (s.length() < k + required - 1) {
            return false;
        }

        Set<String> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i + k));

            if (seen.size() == required) {
                return true;
            }
        }

        return false;
    }
}