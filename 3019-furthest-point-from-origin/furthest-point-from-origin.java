class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l =0,r=0,u=0;

        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i) == 'L'){
                l++;
            }
            else if(moves.charAt(i) == 'R'){
                r++;
            }
            else{
                u++;
            }
        }

        if(l >= r){
            return l+u-r;
        }
        else if(r>l){
            return r+u-l;
        }
        return u;
    }
}