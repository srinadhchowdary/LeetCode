class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][]=new int[m][n];

        for(int col=0;col<n;col++){
            dp[m-1][col] = matrix[m-1][col]; 
        }

        for(int row=m-2;row>=0;row--){
            for(int col=0;col<n;col++){

                int dl = Integer.MAX_VALUE;
                int down = dp[row+1][col];
                int dr = Integer.MAX_VALUE;


                if(col >0){
                    dl = dp[row+1][col-1];
                }
                if(col+1 <n){
                    dr = dp[row+1][col+1];
                }

                int best=matrix[row][col]+Math.min(down,Math.min(dl,dr));
                dp[row][col]=best;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            ans = Math.min(ans, dp[0][col]);
        }

        return ans;
    }
}