class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        temp =[]
        for num in nums:
            if num!=0:
                temp.append(num)
        
        for i in range (len(temp)):
            nums[i]=temp[i]
        
        for i in range(len(temp), len(nums)):
            nums[i]=0