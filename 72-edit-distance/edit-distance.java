class Solution {

    public int findlcs(int ind1,int ind2,String s1,String s2,int[][] dp){

        if(ind1<0) return ind2+1;
        if(ind2<0) return ind1+1;

        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];

        if(s1.charAt(ind1)==s2.charAt(ind2))return 0+findlcs(ind1-1,ind2-1,s1,s2,dp);

        int replace = 1+findlcs(ind1-1,ind2-1,s1,s2,dp);
        int delete = 1+findlcs(ind1-1,ind2,s1,s2,dp);
        int insert = 1+findlcs(ind1,ind2-1,s1,s2,dp);

        dp[ind1][ind2] = Math.min(insert,Math.min(delete,replace));
        return dp[ind1][ind2];
    }
    public int minDistance(String word1, String word2) {


        int n1 =word1.length();
        int n2 = word2.length();
        int dp[][]=new int[n1+1][n2+1];

        for(int i=0;i<n1+1;i++){
            Arrays.fill(dp[i],-1);
        }

        return findlcs(n1-1,n2-1,word1,word2,dp);
        
    }
}