class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<int[]> graph[]= new ArrayList[n];
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            graph[edges[i][0]].add(new int[]{edges[i][1], edges[i][2]});
            graph[edges[i][1]].add(new int[]{edges[i][0], edges[i][2] *2 });
        }
        int cost[]=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty())
        {
            int [] curr=pq.poll();
            for(int i=0;i<graph[curr[0]].size();i++){
                int nextNode=graph[curr[0]].get(i)[0];
                int weight=graph[curr[0]].get(i)[1];
                int dist=cost[curr[0]]+weight;
                if(dist<cost[nextNode]){
                    cost[nextNode]=dist;
                    pq.offer(new int[]{nextNode,dist});
                }
            }
        }
        if (cost[n - 1] == Integer.MAX_VALUE) {
            return -1;
        } 
        else {
            return cost[n - 1];
        }
    }
}