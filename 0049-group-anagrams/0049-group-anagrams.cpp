class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        unordered_map<string, vector<string>> mp;
        for (const string& s : strs) {
            string countKey = string(26, 0); 
            for (char c : s) {
                countKey[c - 'a']++;
            }
            mp[countKey].push_back(s);
        }
        
        vector<vector<string>> result;
        result.reserve(mp.size()); 
        for (auto& pair : mp) {
            result.push_back(move(pair.second)); 
        }
        return result;
    }
};