class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        count_map = {}
        left = 0
        max_fruits = 0
        
        for right in range(len(fruits)):
            current_fruit = fruits[right]
            count_map[current_fruit] = count_map.get(current_fruit, 0) + 1
            
            while len(count_map) > 2:
                left_fruit = fruits[left]
                count_map[left_fruit] -= 1
                
                if count_map[left_fruit] == 0:
                    del count_map[left_fruit]
                
                left += 1
            
            max_fruits = max(max_fruits, right - left + 1)
            
        return max_fruits