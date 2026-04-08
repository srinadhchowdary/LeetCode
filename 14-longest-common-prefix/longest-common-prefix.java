class Solution {
    public String longestCommonPrefix(String[] strs) {

        int n = strs.length;
        if(strs.length == 1)return strs[0];

        Arrays.sort(strs);
        int count =0;

        String s1 = strs[0];
        String s2 = strs[n-1];

        for(int i=0;i<s1.length();i++){

            if(s1.charAt(i) == s2.charAt(i)){
                count++;
            }
            else{
                break;
            }
        }

        if(count == 0)return "";
        return s1.substring(0,count);
    }
}