class Solution {
    public boolean isPalindrome(String s) {

        String ss = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        System.out.println(ss);
    

        StringBuffer sb = new StringBuffer(ss);
        sb = sb.reverse();
        System.out.println(sb.toString());



        int n= ss.length();

        for(int i=0;i<n;i++){
            if(ss.charAt(i)!=sb.charAt(i)){
                return false;
            }
        }
        return true;
    }
}