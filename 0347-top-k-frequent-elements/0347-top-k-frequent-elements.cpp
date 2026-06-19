class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int n = nums.size();
        unordered_map<int, int> counts;
        for (int num : nums) {
            counts[num]++;
        }
        vector<vector<int>> buckets(n + 1);
        for (auto& [num, freq] : counts) {
            buckets[freq].push_back(num);
        }
        vector<int> result;
        result.reserve(k);         
        for (int freq = n; freq >= 0 && result.size() < k; freq--) {
            if (!buckets[freq].empty()) {
                for (int num : buckets[freq]) {
                    result.push_back(num);
                    if (result.size() == k) break;
                }
            }
        }
        return result;
    }
};