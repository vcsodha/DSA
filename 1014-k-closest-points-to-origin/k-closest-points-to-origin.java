class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        int idx= 0;
        for (int[] point : points) {
            int x1 = point[0];
            int y1 = point[1];
            int sqrt = (x1 * x1) + (y1 * y1);
            pq.offer(new int[]{sqrt, idx});
            idx++;
        }
        
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] top = pq.poll();
            ans[i] = points[top[1]];
        }
        return ans;
    }
}
