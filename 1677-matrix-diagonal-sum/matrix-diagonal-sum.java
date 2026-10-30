class Solution {
    public int diagonalSum(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int l=0;
        int r=m-1;

        int lsum =0;

        for(int i=0;i<n;i++){

            if(l< n && r>=0){
                lsum+=mat[i][l];
                if(l != r){
                    lsum+=mat[i][r];
                }
                r--;
                l++;
            }
        }
        return lsum;
    }
}