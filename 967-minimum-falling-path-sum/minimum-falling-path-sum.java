class Solution {

    public int find(int row,int col,int[][] matrix,boolean[][] visited,int[][] dp){

        if(row<0 || col<0 || row>= matrix.length || col>= matrix[0].length){
            return Integer.MAX_VALUE;
        }

        if(row == matrix.length-1)return matrix[row][col];

        if(visited[row][col])return dp[row][col];

        int ld = 0,bot= 0,rd=0;
        
        ld = find(row+1,col-1,matrix,visited,dp);
        bot = find(row+1,col,matrix,visited,dp);
        rd = find(row+1,col+1,matrix,visited,dp);

        dp[row][col]=matrix[row][col]+Math.min(ld,Math.min(bot,rd));
        visited[row][col] = true;

        
        return dp[row][col];
    }
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        boolean visited[][]=new boolean[m][n];
        int dp[][]=new int[m][n];

        int ans = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            int current = find(0, col, matrix, visited, dp);
            ans = Math.min(ans, current);
        }

        return ans;
    }
}