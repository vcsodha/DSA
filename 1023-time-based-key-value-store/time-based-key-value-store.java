class TimeMap {
    HashMap<String, List<Pair<String, Integer>>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key, new ArrayList<>());
        mp.get(key).add(new Pair(value, timestamp));
    }
    public String get(String key, int timestamp) {
        String res = "";
        if (mp.containsKey(key)) {
            List<Pair<String, Integer>> temp = mp.get(key);
            int l = 0, r = temp.size() - 1;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(temp.get(mid).getValue() <= timestamp) {
                    res = temp.get(mid).getKey();
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */