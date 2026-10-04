class Solution {


    public int find(int row,int col,int[][] obstacleGrid,int[][] dp){

        if(row>= 0 && col>=0 && obstacleGrid[row][col] == 1){
            return 0;
        }
        if(row == 0 && col == 0)return 1;
        if(row <0 || col<0)return 0;

        if(dp[row][col] != -1)return dp[row][col];
        
        int up = find(row-1,col,obstacleGrid,dp);
        int left = find(row,col-1,obstacleGrid,dp);

        dp[row][col] = up+left;
        return dp[row][col];

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int dp[][] = new int[row][col];

        for(int i=0;i<row;i++){
            Arrays.fill(dp[i],-1);
        }

        return find(row-1,col-1,obstacleGrid,dp);
    }
}