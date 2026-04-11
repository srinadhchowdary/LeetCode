class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128];

        // count frequency
        for(char ch : s.toCharArray()){
            freq[ch]++;
        }

        int len = 0;

        for(int count : freq){
            len += (count / 2) * 2; // take even part

            if(len % 2 == 0 && count % 2 == 1){
                len += 1; // add one odd in center
            }
        }

        return len;
    }
}