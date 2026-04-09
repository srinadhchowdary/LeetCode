class Solution {
    public String toGoatLatin(String sentence) {

        String sent[] = sentence.split(" ");

        for(int i=0;i<sent.length;i++){
            StringBuilder sb  = new StringBuilder(sent[i]);

            char ch = sb.charAt(0);
            if(ch == 'a' || ch=='e' || ch == 'i' || ch == 'o' || ch == 'u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch =='U'){
                sb.append("ma");
            }
            else{
                sb.deleteCharAt(0);
                sb.append(ch+"ma");
            }
            sb.append("a".repeat(i+1));
            sent[i] = sb.toString();
        }
        
        return String.join(" ", sent);
    }
}