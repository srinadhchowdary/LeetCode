class Solution {
    public int maxNumberOfBalloons(String text) {


        int ch[] = new int[26];

        String b = "balloon";

        int balloon[] = new int[26];
        for(int i=0;i<b.length();i++){
            balloon[b.charAt(i)-'a']++;
        }

        for(int i=0;i<text.length();i++){
            ch[text.charAt(i)-'a']++;
        }

        int ins = Integer.MAX_VALUE;

        for(int i=0;i<balloon.length;i++){

            if(balloon[i] > 0){
                ins = Math.min(ins,ch[i]/balloon[i]);
            }
        }

        return ins;
        
    }
}