class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(String s, int st, List<String> curr, List<List<String>> res) {
        if (st == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = st; i < s.length(); i++) {
            if (isPalindrome(s, st, i)) {
                curr.add(s.substring(st, i + 1));
                backtrack(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int st, int en) {
        while (st < en) {
            if (s.charAt(st++) != s.charAt(en--)) {
                return false;
            }
        }
        return true;
    }
}