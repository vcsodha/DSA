class Solution {
    public String multiply(String nums1, String nums2) {
        if("0".equals(nums1) || "0".equals(nums2))
        {
            return "0";
        }
        int[] ans=new int[nums1.length()+nums2.length()-1];
        for(int i=0;i<nums1.length();i++)
        {
            for(int j=0;j<nums2.length();j++)
            {
                ans[i+j] +=(nums1.charAt(i) - '0') * (nums2.charAt(j) -'0');
            }
        }
        for(int i=ans.length-1;i>0;i--)
        {
            ans[i-1] += ans[i] /10;
            ans[i] %= 10;
        }
        StringBuilder sb=new StringBuilder();
        for(int i:ans)
        {
            sb.append(i);
        }
        return sb.toString();
    }
}