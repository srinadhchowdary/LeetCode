class Solution {
    public char findTheDifference(String s, String t) {

        char s1[]=s.toCharArray();
        char s2[]=t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        char ch = ' ';

        for(int i=0;i<s2.length;i++){

            if(i == s2.length-1 || s1[i] != s2[i]){
                ch = s2[i];
                break;
            }
        }

        return ch;
        
    }
}