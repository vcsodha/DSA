class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> list=new HashSet<>();
        for(int num:nums)
        {
            if(list.contains(num))
            {
                return num;
            }
            else
            {
                list.add(num);
            }
        }
        return -1;
    }
}