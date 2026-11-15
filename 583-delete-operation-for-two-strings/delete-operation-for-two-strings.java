class Solution {

    public int findLcs(int ind1,int ind2,int[][] dp,String word1,String word2){

        if(ind1 <0 || ind2<0)return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        

        return dp[ind1][ind2]; 
    }
    public int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        int dp[][] = new int[n1+1][n2+1];

        for(int i=0;i<n1+1;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<n2+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] =  1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lcs = dp[n1][n2];
        int ans = n1+n2-(2*lcs);
        return ans;
        
    }
}