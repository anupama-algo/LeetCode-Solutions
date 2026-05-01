class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_set = set() # This "Set" keeps track of unique characters
        left = 0         # The left side of our "window"
        max_length = 0
        
        # 'right' moves across the string one by one
        for right in range(len(s)):
            # If we see a character that's ALREADY in our set:
            # We shrink the window from the left until that character is gone
            while s[right] in char_set:
                char_set.remove(s[left])
                left += 1
            
            # Now the window is "clean," so we add the new character
            char_set.add(s[right])
            
            # Calculate the current window size and save if it's the biggest
            max_length = max(max_length, right - left + 1)
            
        return max_length