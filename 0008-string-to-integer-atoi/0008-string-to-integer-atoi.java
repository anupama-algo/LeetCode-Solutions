class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int i = 0;
        int n = s.length();
        
        // 1. Read and ignore leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // If string contains only whitespaces
        if (i == n) {
            return 0;
        }
        
        // 2. Check the sign character
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        
        // 3. Read digits and handle 32-bit signed integer overflow/underflow
        int result = 0;
        while (i < n) {
            char ch = s.charAt(i);
            
            // Stop when encountering a non-digit character
            if (ch < '0' || ch > '9') {
                break;
            }
            
            int digit = ch - '0';
            
            // 4. Check overflow before multiplying
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}