class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n=queries.length, m=intervals.length;
        int [] result=queries.clone(), ans=new int[n];
        Arrays.sort(result);
        int i=0;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        TreeMap<Integer, Integer> mt = new TreeMap<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int x:result)
        {
            while(i<m && intervals[i][0] <= x)
            {
                int r=intervals[i][1], l=intervals[i++][0];
                mt.put(r-l+1,r);
            }
            while(!mt.isEmpty() && mt.firstEntry().getValue() <x)
            {
                mt.pollFirstEntry();
            }
            if (mt.isEmpty()) 
            {
                mp.put(x, -1);
            }    
            else 
            {
                mp.put(x, mt.firstKey());
            }
        }
        i=0;
        for(int y:queries)
        {
            ans[i++] =mp.get(y);
        }
        return ans;
    }
}