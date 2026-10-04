class Solution {


    public int find(int row,int col,int[][] grid,int[][]dp){

        if(row == 0 && col == 0)return grid[row][col];
        if(row <0 || col<0)return Integer.MAX_VALUE;

        if(dp[row][col] != -1)return dp[row][col];

        int up = find(row-1,col,grid,dp);
        int left = find(row,col-1,grid,dp);

        dp[row][col] = grid[row][col]+Math.min(up,left);

        return dp[row][col];
    }
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int dp[][]= new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(m-1,n-1,grid,dp);
        
    }
}