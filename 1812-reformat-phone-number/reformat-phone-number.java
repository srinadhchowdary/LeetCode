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

        if(remaining == 4){
            sb.append(number.substring(ind,ind+2));
            sb.append("-");
            sb.append(number.substring(ind+2,ind+4));   
        }
        else{
            sb.append(number.substring(ind));
        }

    return sb.toString();
    }
}