class Solution {
    public char findTheDifference(String s, String t) {

        // 0^a = a
        // a^a = 0

        char result = 0;
        for(char ch:s.toCharArray()){
            result ^= ch;
        }

        for(char ch:t.toCharArray()){
            result ^= ch;
        }

        return result;
    }
}