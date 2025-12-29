import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        
        return backtrack(bottom, "", map);
    }

    private boolean backtrack(String current, String next, Map<String, List<Character>> map) {
        if (current.length() == 1) {
            return true;
        }
        if (next.length() == current.length() - 1) {
            return backtrack(next, "", map);
        }
        int i = next.length();
        String key = current.substring(i, i + 2);

        if (map.containsKey(key)) {
            for (char c : map.get(key)) {
                if (backtrack(current, next + c, map)) {
                    return true;
                }
            }
        }

        return false;
    }
}