class Solution {
    public int longestPalindrome(String s) {

        Map<Character,Integer> mp = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            mp.put(ch ,mp.getOrDefault(ch,0)+1);
        }

        boolean odd = false;
        int len = 0;

        for(char ch : mp.keySet()){
            int val = mp.get(ch);

            if(val % 2 == 1 && !odd){
                odd = true;
                len += val;
                continue;
            }
            else if(val %2 == 0){
                len += val;
                continue;
            }
            len += val-1;
        }
    return len; 
    }
}