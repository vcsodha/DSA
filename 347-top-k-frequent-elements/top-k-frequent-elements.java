class Solution {
    public int[] topKFrequent(int[] nums, int k) {
	List<Integer>[] freqSorted = new List[nums.length +1];
	Map<Integer, Integer> frequencyMap = new HashMap();
	List<Integer> res = new ArrayList();

	for(int n: nums)
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    for(int key: frequencyMap.keySet()){
	   if(freqSorted[frequencyMap.get(key)] == null)
		   freqSorted[frequencyMap.get(key)] = new ArrayList();
	   freqSorted[frequencyMap.get(key)].add(key);
   }
   for(int i = freqSorted.length - 1; i >= 0 && res.size() < k; i--){
	   if(freqSorted[i] != null){
			res.addAll(freqSorted[i]);
        }
    }
    return res.stream().mapToInt(i->i).toArray();
    }
}