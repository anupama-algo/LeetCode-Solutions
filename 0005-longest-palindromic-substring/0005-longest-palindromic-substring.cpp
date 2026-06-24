class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size(), start = 0, max_len = 0;
        for (int i = 0; i < n; i++) {
            for (int j : {i, i + 1}) { // Covers odd and even centers
                int l = i, r = j;
                while (l >= 0 && r < n && s[l] == s[r]) { l--; r++; }
                if (r - l - 1 > max_len) {
                    start = l + 1;
                    max_len = r - l - 1;
                }
            }
        }
        return s.substr(start, max_len);
    }
};