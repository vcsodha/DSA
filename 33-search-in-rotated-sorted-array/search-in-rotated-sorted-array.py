class Solution:
    def search(self, nums: List[int], target: int) -> int:
        lo, high = 0, len(nums)-1
        while lo<=high:
            mid= (lo +high) //2
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[lo]:
                if target >= nums[lo] and target <= nums[mid]:
                    high = mid-1
                else:
                    lo = mid+1
            else:
                if target<= nums[high] and target >= nums[mid]:
                    lo=mid+1
                else:
                    high = mid-1
        return -1

