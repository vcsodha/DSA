class Solution {
    public int minOperations(int[] nums) {
         int n = nums.length ;

        int[] stack = new int[n] ;
        int top = -1 ;

        int res = 0 ;

        for(int i = 0 ; i < n ; i++)
        {
            int num = nums[i] ;

            if(top == -1 || stack[top]  < num)
            {
                stack[++top] = num ;
                continue ;
            }

            while(top > -1 && stack[top] > num)
            {
                top -- ;
                res ++ ;
            }

            if(top  == -1 || stack[top] != num) stack[++ top] = num ;
            
        }

        if(top > -1 && stack[0] == 0) res += top ;
        else res += top + 1 ;

        return res ;
    }
}