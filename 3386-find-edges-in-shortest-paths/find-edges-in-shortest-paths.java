class Solution {
    static class Adj {
        int to;
        int w;
        Adj(int to, int w) { this.to = to; this.w = w; }
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        List<Adj>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new Adj(v, w));
            g[v].add(new Adj(u, w));
        }

        long[] distS = dijkstra(n, g, 0);
        long[] distT = dijkstra(n, g, n - 1);

        long best = distS[n - 1];
        boolean[] ans = new boolean[edges.length];
        if (best == Long.MAX_VALUE) return ans;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            boolean ok = false;
            if (distS[u] != Long.MAX_VALUE && distT[v] != Long.MAX_VALUE) {
                if (distS[u] + (long) w + distT[v] == best) ok = true;
            }
            if (!ok && distS[v] != Long.MAX_VALUE && distT[u] != Long.MAX_VALUE) {
                if (distS[v] + (long) w + distT[u] == best) ok = true;
            }
            ans[i] = ok;
        }
        return ans;
    }

    private long[] dijkstra(int n, List<Adj>[] g, int src) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<long[]> pq =
            new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0L, src});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d != dist[u]) continue;

            for (Adj e : g[u]) {
                long nd = d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.add(new long[]{nd, e.to});
                }
            }
        }
        return dist;
    }
}