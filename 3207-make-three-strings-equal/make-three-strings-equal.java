class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {

        int minlen = 0;
        minlen = Math.min(s1.length(),Math.min(s2.length(),s3.length()));

        int i=0;
        while(i<minlen){
            if(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }
        if(i == 0)return -1;
        int ans = (s1.length() - i) + (s2.length() -i) + (s3.length() -i);
        return ans;


    }
}