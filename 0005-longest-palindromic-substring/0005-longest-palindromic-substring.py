class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        
        start, end = 0, 0
        
        def expandAroundCenter(left: int, right: int) -> int:
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            # Return the length of the palindrome
            return right - left - 1

        for i in range(len(s)):
            # Check for odd length (e.g., "aba")
            len1 = expandAroundCenter(i, i)
            # Check for even length (e.g., "abba")
            len2 = expandAroundCenter(i, i + 1)
            
            max_len = max(len1, len2)
            
            if max_len > (end - start):
                # Update indices based on the new max length
                start = i - (max_len - 1) // 2
                end = i + max_len // 2
                
        return s[start : end + 1]