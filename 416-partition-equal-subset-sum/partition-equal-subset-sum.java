class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum=0;
        for(int num:nums)
        {
            totalsum +=num;
        }
        if(totalsum%2 !=0)
        {
            return false;
        }
        int targetsum=totalsum/2;
        boolean[] dp=new boolean[targetsum+1];
        dp[0]=true;
        for(int num :nums)
        {
            for(int curr=targetsum;curr>=num;curr--)
            {
                dp[curr]=dp[curr] || dp[curr-num];
                if(dp[targetsum])
                {
                    return true;
                }
            }
        }
        return dp[targetsum];
    }
}