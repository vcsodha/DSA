class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
         int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        int maxLen = 0;
        for (String w : wordDict) maxLen = Math.max(maxLen, w.length());

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;

            for (String w : wordDict) {
                int len = w.length();
                if (i + len <= n && s.startsWith(w, i)) {
                    dp[i + len] = true;
                }
            }
        }
        return dp[n];
    }
}