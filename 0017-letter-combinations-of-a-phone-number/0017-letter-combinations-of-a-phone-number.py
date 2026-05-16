class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        if not digits:
            return []
        
        # Keypad mapping
        phone = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"
        }
        
        res = []
        
        def backtrack(index, path):
            # If the path length matches digits length, we found a combination
            if len(path) == len(digits):
                res.append("".join(path))
                return
            
            # Get letters for current digit and recurse
            possible_letters = phone[digits[index]]
            for letter in possible_letters:
                path.append(letter)
                backtrack(index + 1, path)
                path.pop() # Backtrack: remove letter before trying next
                
        backtrack(0, [])
        return res