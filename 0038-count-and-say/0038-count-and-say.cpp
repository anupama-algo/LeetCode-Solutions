class Solution {
public:
    string countAndSay(int n) {
        if (n == 1) return "1";
        
        string res = "1";
        for (int i = 2; i <= n; i++) {
            string temp = "";
            int count = 1;
            for (int j = 0; j < res.length(); j++) {
                if (j + 1 < res.length() && res[j] == res[j+1]) {
                    count++;
                } else {
                    temp += to_string(count) + res[j];
                    count = 1;
                }
            }
            res = temp;
        }
        return res;
    }
};