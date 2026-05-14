class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        seen = {}  # Dictionary to store {number: index}
        
        for i, num in enumerate(nums):
            # Check if we saw this number before and if the distance is <= k
            if num in seen and i - seen[num] <= k:
                return True
            
            # Update the dictionary with the current index
            seen[num] = i
            
        return False