class Solution {
    public int longestBalanced(String s) {
        int l=s.length();
        int[] count=new int[26];
        int ans=0;
        for(int i=0;i<l;++i)
        {
            Arrays.fill(count,0);
            int max=0,v=0;
            for(int j=i;j<l;++j)
            {
                int ch=s.charAt(j) - 'a';
                if(++count[ch] ==1)
                {
                    ++v;
                }
                max=Math.max(max,count[ch]);
                if(max*v==j-i+1)
                {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}