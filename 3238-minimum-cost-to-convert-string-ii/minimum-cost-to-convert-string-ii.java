class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {

        HashMap<String, Integer> id = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < original.length; i++) {
            if (!id.containsKey(original[i])) {
                id.put(original[i], idx);
                idx++;
            }
            if (!id.containsKey(changed[i])) {
                id.put(changed[i], idx);
                idx++;
            }
        }
        int n = idx;
        long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = INF;
            }
            dist[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int a = id.get(original[i]);
            int b = id.get(changed[i]);
            long c = cost[i];
            if (c < dist[a][b]) {
                dist[a][b] = c;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == INF) {
                        continue;
                    }
                    long newCost = dist[i][k] + dist[k][j];
                    if (newCost < dist[i][j]) {
                        dist[i][j] = newCost;
                    }
                }
            }
        }

        ArrayList<Integer> lens = new ArrayList<>();
        for (int i = 0; i < original.length; i++) {
            int L = original[i].length();
            boolean exists = false;
            for (int j = 0; j < lens.size(); j++) {
                if (lens.get(j) == L) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                lens.add(L);
            }
        }
        int m = source.length();
        long[] dp = new long[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            if (dp[i] == INF) {
                continue;
            }
            if (source.charAt(i) == target.charAt(i)) {
                if (dp[i] < dp[i + 1]) {
                    dp[i + 1] = dp[i];
                }
            }
            for (int t = 0; t < lens.size(); t++) {
                int L = lens.get(t);
                int j = i + L;
                if (j > m) {
                    continue;
                }

                String aStr = source.substring(i, j);
                String bStr = target.substring(i, j);
                Integer aId = id.get(aStr);
                Integer bId = id.get(bStr);
                if (aId == null || bId == null) {
                    continue;
                }
                long c = dist[aId][bId];
                if (c == INF) {
                    continue;
                }
                long newDp = dp[i] + c;
                if (newDp < dp[j]) {
                    dp[j] = newDp;
                }
            }
        }
        if (dp[m] == INF) {
            return -1;
        }
        return dp[m];
    }
}
