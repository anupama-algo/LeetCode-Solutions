class Solution:
    def isPalindrome(self, x: int) -> bool:
        s=str(x)
        reversed_s=s[::-1]
        return s==reversed_s        