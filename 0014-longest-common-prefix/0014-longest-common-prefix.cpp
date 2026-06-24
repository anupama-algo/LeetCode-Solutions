class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        sort(strs.begin(), strs.end());
        string first = strs.front(), last = strs.back();
        int i = 0;
        while (i < first.size() && first[i] == last[i]) i++;
        return first.substr(0, i);
    }
};