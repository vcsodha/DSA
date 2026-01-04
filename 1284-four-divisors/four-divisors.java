class Solution {
    public int sumFourDivisors(int[] nums) {
        int res=0;
        for(int n:nums)
        {
            int sum =0;
            HashSet<Integer> set= new HashSet<>();
            for(int i=1;i * i <=n;i++)
            {
                if(n%i ==0)
                {
                    set.add(i);
                    set.add(n/i);
                }
            }
            if(set.size()==4)
            {
                for(int val: set)
                {
                    sum += val;
                }
                res += sum;
            }
        }
        return res;
    }
}