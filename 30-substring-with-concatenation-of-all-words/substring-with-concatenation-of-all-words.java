class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0) return ans;

        int wLen = words[0].length();
        int totalWords = words.length;

        Map<String, Integer> need = new HashMap<>();
        for (String w : words)
            need.put(w, need.getOrDefault(w, 0) + 1);

        // try each possible alignment
        for (int start = 0; start < wLen; start++) {

            Map<String, Integer> seen = new HashMap<>();
            int left = start, count = 0;

            for (int right = start; right + wLen <= s.length(); right += wLen) {
                String word = s.substring(right, right + wLen);

                if (!need.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = right + wLen;
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                while (seen.get(word) > need.get(word)) {
                    String leftWord = s.substring(left, left + wLen);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    left += wLen;
                    count--;
                }

                if (count == totalWords)
                    ans.add(left);
            }
        }

        return ans;
    }
}