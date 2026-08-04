class Solution:
    def maxArea(self, height: List[int]) -> int:
        p1 = 0
        p2 = len(height) - 1
        max_water = 0
        
        while p1 < p2:
            current_width = p2 - p1
            current_height = min(height[p1], height[p2])
            current_water = current_width * current_height
            
            max_water = max(max_water, current_water)
            
            if height[p1] < height[p2]:
                p1 += 1
            else:
                p2 -= 1
                
        return max_water