class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        map={}
        stack=[]
        for num in nums2:
            while stack and stack[-1]<num:
                map[stack.pop()]=num
            stack.append(num)
        ans=[]
        for num in nums1:
            ans.append(map.get(num,-1))
        return ans