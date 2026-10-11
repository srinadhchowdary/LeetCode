class Solution {
    // Space Optimization

    // Time Complexity : O(N X M) + O(M)
    // Space Complexity : O(N)



    public int minFallingPathSum(int[][] matrix) {


        int m= matrix.length;
        int n= matrix[0].length;

    
        int prev[]=new int[n];

        for(int j=0;j<n;j++){
            prev[j] = matrix[0][j];
        }

        for(int i=1;i<m;i++){
            int curr[]=new int[n];


            for(int j=0;j<n;j++){

                int up = matrix[i][j] + prev[j];
                int ld = matrix[i][j];
                if(j-1>=0){
                ld += prev[j-1];}
                else{
                    ld = Integer.MAX_VALUE;
                }
                int rd = matrix[i][j];
                if(j+1 < n){
                rd += prev[j+1];}
                else{
                    rd = Integer.MAX_VALUE;
                }

                curr[j] = Math.min(up,Math.min(ld,rd));
            }
            prev = curr;
        }
        
        int min = Integer.MAX_VALUE;

        for(int j= 0;j<n;j++){
            min = Math.min(min,prev[j]);
        }
        return min;
        


        
    }
}