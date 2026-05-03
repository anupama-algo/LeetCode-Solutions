class Solution:
    def isValid(self, s: str) -> bool:
        # Step 1: Create a stack (list) to store openers
        stack = []
        
        # Step 2: Create a map of 'closer' to 'opener'
        mapping = {")": "(", "}": "{", "]": "["}
        
        # Step 3: Iterate through every character in the string
        for char in s:
            # If it's a closer
            if char in mapping:
                # Pop the top element from stack (if empty, use dummy '#')
                top_element = stack.pop() if stack else '#'
                
                # If the popped opener doesn't match the required one, return False
                if mapping[char] != top_element:
                    return False
            else:
                # It's an opener, so push it onto the stack
                stack.append(char)
        
        # Step 4: If the stack is empty, all brackets were correctly matched
        return not stack