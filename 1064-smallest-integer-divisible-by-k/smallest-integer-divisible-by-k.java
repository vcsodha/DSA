class Solution {
    public int smallestRepunitDivByK(int i) {
        if(i == 2 || i == 5)
        {
            return -1;
        }
        int rem = 0;
        for(int length = 1; length<=i; length++)
        {
            rem = (rem*10 + 1) % i;   
            if(rem == 0)
            {
                return length;
            }
        }
        return -1;
    }
}