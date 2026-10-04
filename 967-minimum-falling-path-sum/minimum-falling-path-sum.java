class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[]=new int[n];

        for(int col=0;col<n;col++){
            dp[col] = matrix[m-1][col]; 
        }

        for(int row=m-2;row>=0;row--){
            int temp[] = new int[n];
            for(int col=0;col<n;col++){

                int dl = Integer.MAX_VALUE;
                int down = dp[col];
                int dr = Integer.MAX_VALUE;


                if(col >0){
                    dl = dp[col-1];
                }
                if(col+1 <n){
                    dr = dp[col+1];
                }

                int best=matrix[row][col]+Math.min(down,Math.min(dl,dr));
                temp[col]=best;
            }
            dp = temp;
        }
        
        int ans = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            ans = Math.min(ans, dp[col]);
        }

        return ans;
    }
}