class Solution {
    public String reformatNumber(String number) {

        number = number.replace("-", "").replace(" ", "");

        int n= number.length();
        int count = 0;

        while(n > 4){
            n = n-3;
            count++;
        }

        int remaining = n;

        int ind = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<count;i++){
            sb.append(number.substring(ind,ind+3));
            sb.append("-");
            ind += 3;
        }

        if(n == 3){
            sb.append(number.substring(number.length()-3,number.length()));
        }
        else{

            while(n!=0){
                
                sb.append(number.substring(number.length()-n , number.length()-n+2));
                sb.append("-");
                n-=2;
            }
        }
    if(sb.charAt(sb.length()-1) == '-'){
        sb.deleteCharAt(sb.length()-1);

    }
    return sb.toString();
    }
}