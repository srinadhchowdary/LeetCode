class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        Set<Character> st = new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            st.add(jewels.charAt(i));
        }

        int ans = 0;
        for(char ch:stones.toCharArray()){
            if(st.contains(ch)){
                ans++;
            }
        }
        return ans;
    }
}