class Solution {

    public int DisSub(int i,int j,String s,String t,int[][]dp){
        if(j==0)return 1;
        if(i==0)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(s.charAt(i-1) == t.charAt(j-1)){
            dp[i][j] =  DisSub(i-1,j-1,s,t,dp)+DisSub(i-1,j,s,t,dp);
            return dp[i][j];
        }

        dp[i][j] = DisSub(i-1,j,s,t,dp);

        return dp[i][j];
    }
    public int numDistinct(String s, String t) {

        int n= s.length(),m= t.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        return DisSub(n,m,s,t,dp);
        
    }
}