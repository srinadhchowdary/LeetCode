class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128]; // hash array

        // same counting logic
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch]++;
        }

        boolean odd = false;
        int len = 0;

        // same logic as your map loop
        for(int i = 0; i < 128; i++){
            int val = freq[i];

            if(val % 2 == 1 && !odd){
                odd = true;
                len += val;
                continue;
            }
            else if(val % 2 == 0){
                len += val;
                continue;
            }
            len += val - 1;
        }

        return len;
    }
}