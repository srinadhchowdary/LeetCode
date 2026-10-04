class Solution {

    public int find(int row,int col,int[][] matrix,int[][] dp){

        if(row<0 || col<0 || row>= matrix.length || col>= matrix[0].length){
            return Integer.MAX_VALUE;
        }

        if(row == matrix.length-1)return matrix[row][col];

        if(dp[row][col] != Integer.MAX_VALUE)return dp[row][col];
        int ld = 0,bot= 0,rd=0;
        
        ld = find(row+1,col-1,matrix,dp);
        bot = find(row+1,col,matrix,dp);
        rd = find(row+1,col+1,matrix,dp);

        dp[row][col]=matrix[row][col]+Math.min(ld,Math.min(bot,rd));

        
        return dp[row][col];
    }
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            int current = find(0, col, matrix, dp);
            ans = Math.min(ans, current);
        }

        return ans;
    }
}