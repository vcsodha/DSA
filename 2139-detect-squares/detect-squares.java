class DetectSquares {

    HashMap<String, Integer> map;
    List<int[]> list;
    public DetectSquares() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public void add(int[] point) {
        String key = getKey(point);
        map.put(key, map.getOrDefault(key,0)+1);
        
        list.add(point);
    }
    
    public int count(int[] point) {
        int ans=0;
        
        int x=point[0];
        int y=point[1];
        
        for(int[] curr : list){
            if(Math.abs(y-curr[1])!=Math.abs(x-curr[0]) || y==curr[1] || x==curr[0]) continue;
            
            ans+=getMapValue(getKey(new int[]{x, curr[1]})) * getMapValue(getKey(new int[]{curr[0], y}));
        }
        return ans;
    }
    
    private String getKey(int point[]){
        return point[0]+"_"+point[1];
    }
    
    private int getMapValue(String key){
        return map.containsKey(key) ? map.get(key) : 0;
    }
}