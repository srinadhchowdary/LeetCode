class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        HashMap<Character,Integer> mp = new HashMap<>();

        for(int i=0;i<stones.length();i++){
            mp.put(stones.charAt(i),mp.getOrDefault(stones.charAt(i),0)+1);
        }

        int ans = 0;
        for(int i=0;i<jewels.length();i++){
            if(mp.containsKey(jewels.charAt(i))){
                ans += mp.get(jewels.charAt(i));
            }
        }
        
        return ans;
    }
}