class Solution {
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        bkt(1,1,n,k,list,ans);
        return ans;
        
    }
    public void bkt(int ind,int start,int n,int k, List<Integer> list,List<List<Integer>> ans)
    {
        if(ind>k)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        else
        {
            for(int i=start ;i<=n ;i++)
            {
                list.add(i);
                bkt(ind+1,i+1,n,k,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
}