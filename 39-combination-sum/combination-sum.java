public class Solution {
    public List<List<Integer>> combinationSum(int[] cands, int t) {
        Arrays.sort(cands); 
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { 
            List<List<Integer>> newList = new ArrayList(); 
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
}