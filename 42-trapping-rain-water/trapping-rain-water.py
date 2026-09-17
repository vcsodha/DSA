class Solution:
    def trap(self, height: list[int]) -> int:
        water_trapped=0
        n=len(height)
        l,r = 0,n-1
        l_max,r_max=0,0

        while l<r:
            l_max=max(l_max,height[l])
            r_max=max(r_max,height[r])

            if l_max<r_max:
                water_trapped += l_max-height[l]
                l+=1
            else:
                water_trapped += r_max-height[r]
                r-=1
            
        return water_trapped
