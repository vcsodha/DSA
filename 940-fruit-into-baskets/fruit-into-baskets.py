class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        c_map={}
        left,max_fruits=0,0

        for right in range(len(fruits)):
            curr=fruits[right]
            c_map[curr]=c_map.get(curr,0) +1
            while len(c_map)>2:
                left_fruits=fruits[left]
                c_map[left_fruits] -=1

                if c_map[left_fruits] == 0:
                    del c_map[left_fruits]
                
                left +=1
            
            max_fruits = max(max_fruits,right-left+1)

        return max_fruits