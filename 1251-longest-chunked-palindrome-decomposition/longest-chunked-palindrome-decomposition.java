class Solution 
{
    public int longestDecomposition(String text) 
    {
        int ans=0;
        for(int i = 0, j = text.length() - 1;i<=j;)
        {
            boolean isDecomposed = false;
            for(int l = 1;i+l-1<j-l+1;l++)
            {
                if(text.substring(i,i+l).equals(text.substring(j-l+1,j+1)))
                {
                    i = i+l;
                    j = j-l;
                    ans += 2;
                    isDecomposed = true;
                    break;
                }
            }
            if(!isDecomposed)
            {
                ans += 1;
                break;
            }
        }
        return ans;
    }
}