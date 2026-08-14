class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        k %=n
        count =0
        start=0
        while count<n:
            current=start
            prev=nums[start]

            while True:
                idx=(current +k) %n
                nums[idx],prev =prev,nums[idx]
                current=idx
                count +=1

                if start == current:
                    break 
            start +=1