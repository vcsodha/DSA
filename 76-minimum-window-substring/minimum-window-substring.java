class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> counter = new HashMap<>();
        int[] ans = new int[2];

        for(int i =0;i<t.length();i++){
            counter.put(t.charAt(i),0);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int match = 0;

        while(end<s.length()){
            Character temp = s.charAt(end);
            if(map.containsKey(temp)){
                if(counter.get(temp)<map.get(temp)){
                    match++;
                }
                counter.put(temp,counter.get(temp)+1);
            }
            while(match==t.length()){
                if(end-start+1<min){
                    min = end-start+1;
                    ans[0] = start;
                    ans[1] = end+1;
                }
                temp = s.charAt(start);
                if(map.containsKey(temp)){
                    if(counter.get(temp)<=map.get(temp)){
                        match--;
                    }
                    counter.put(temp,counter.get(temp)-1);
                }
                start++;
            }
            end++;
        }
        return new String(s.substring(ans[0],ans[1]));
    }
}