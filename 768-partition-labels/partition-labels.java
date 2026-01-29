class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                partitions.add(i - start + 1);
                start = i + 1;
            }
        }
        return partitions;
    }
}