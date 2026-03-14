class Solution 
{
    public String breakPalindrome(String palindrome) 
    {
        int len=palindrome.length();
        char strarr[]=palindrome.toCharArray();
        for(int i=0;i<len/2;i++)
        {
            if(strarr[i]!='a')
            {
                strarr[i]='a';
                return String.valueOf(strarr);
            }
        }
        strarr[len-1]= 'b';
        if (len <= 1) 
        {
            return "";
        } 
        else 
        {
            return String.valueOf(strarr);
        }
    }
}