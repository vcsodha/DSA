class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (ans.length() < r - l - 1) {
                ans = s.substring(l + 1, r);
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (ans.length() < r - l - 1) {
                ans = s.substring(l + 1, r);
            }
        }
        return ans;
    }
}
