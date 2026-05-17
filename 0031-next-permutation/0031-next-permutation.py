class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        pivot = -1
        
        # 1. Find the first decreasing element from the right
        for i in range(n - 2, -1, -1):
            if nums[i] < nums[i + 1]:
                pivot = i
                break
        
        if pivot == -1:
            # Entire array is in descending order; reverse to get ascending
            nums.reverse()
            return

        # 2. Find the smallest element larger than the pivot to its right
        for j in range(n - 1, pivot, -1):
            if nums[j] > nums[pivot]:
                # 3. Swap them
                nums[pivot], nums[j] = nums[j], nums[pivot]
                break
        
        # 4. Reverse the suffix to make it the smallest lexicographical sequence
        nums[pivot + 1:] = reversed(nums[pivot + 1:])