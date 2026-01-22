class Solution {
    public int maxProduct(int[] nums) {
        int result= Integer.MIN_VALUE;
        for(int n: nums)
        {
            result=Math.max(result,n);
        }
        int max=1, min=1;
        for(int n: nums)
        {
            int temp=max * n;
            max=Math.max(temp,Math.max(min* n , n));
            min=Math.min(temp,Math.min(min*n, n));
            result=Math.max(result,max);
        }
        return result;
    }
}