class Solution {
    // Tabulation

    // Time Complexity : O(N X M) those are the no of states at max we have
    // Space Complexity : O(N X M)(matrix) + O(N) (recursion stack space)



    public int minFallingPathSum(int[][] matrix) {


        int m= matrix.length;
        int n= matrix[0].length;

    
        int dp[][]=new int[m][n];

        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1;i<m;i++){


            for(int j=0;j<n;j++){

                
                int up = matrix[i][j] + dp[i-1][j];
                int ld = matrix[i][j];
                if(j-1>=0){
                ld += dp[i-1][j-1];}
                else{
                    ld = Integer.MAX_VALUE;
                }
                int rd = matrix[i][j];
                if(j+1 < n){
                rd += dp[i-1][j+1];}
                else{
                    rd = Integer.MAX_VALUE;
                }

                dp[i][j] = Math.min(up,Math.min(ld,rd));
            }
        }
        
        int min = Integer.MAX_VALUE;

        for(int j= 0;j<n;j++){
            min = Math.min(min,dp[m-1][j]);
        }
        return min;
        


        
    }
}