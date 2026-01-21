class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int from=table(nums,0,n-2);
        int from1=table(nums,1,n-1);
        return Math.max(from, from1);
    }
    public int table(int[] nums, int start, int end)
    {
        int len=end-start+1;
        int []dp=new int [len+1];
        dp[0]=0;
        dp[1]=nums[start];

        for(int i=2;i<=len;i++)
        {
            int opt=nums[start+i-1] + dp[i-2];
            int opt1=dp[i-1];
            dp[i]=Math.max(opt,opt1);
        }
        return dp[len];
    }
}