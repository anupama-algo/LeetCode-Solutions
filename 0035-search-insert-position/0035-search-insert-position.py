class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low + high) // 2
            
            if nums[mid] == target:
                return mid  # Target found, return its index
            elif nums[mid] < target:
                low = mid + 1  # Search in the right half
            else:
                high = mid - 1  # Search in the left half
                
        return low  # Target not found, return the insertion index