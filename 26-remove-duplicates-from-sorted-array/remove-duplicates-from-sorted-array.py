class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        unique_elements = sorted(list(set(nums)))
        for i in range(len(unique_elements)):
            nums[i]=unique_elements[i]
        
        return len(unique_elements)