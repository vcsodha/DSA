class Solution {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i:nums)
        {
            arr.add(i);
        }
        int count=0;
        boolean b= false;
        while(!b)
        {
            if(arr.size()<=1)
            {
                return count;
            }
        boolean bo=true;
        for(int i=1;i<arr.size();i++)
        {
            if(arr.get(i) < arr.get(i-1))
            {
                bo=false;
                break;
            }
        }
        if(bo)
        {
            b=true;
        }
        count ++;
        int in=0;
        int sum=Integer.MAX_VALUE;
        for(int i=0;i<arr.size()-1;i++)
        {
            int temp=arr.get(i) + arr.get(i+1);
            if(temp<sum)
            {
                in=i;
                sum=temp;
            }
        }
        arr.remove(in);
        arr.set(in,sum);
        }
        return count-1;
    }
}