class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        if not nums:
            return 0
        
        write_index = 0
        
        for read_index in range(1, len(nums)):
            if nums[read_index] != nums[write_index]:
                write_index += 1
                nums[write_index] = nums[read_index]
                
        return write_index + 1
