class Solution {

    public int findLcs(int ind1,int ind2,int[][] dp,String word1,String word2){

        if(ind1 <0 || ind2<0)return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        
        if(word1.charAt(ind1) == word2.charAt(ind2)){
            return 1+ findLcs(ind1-1,ind2-1,dp,word1,word2);
        }

        dp[ind1][ind2] = Math.max(findLcs(ind1-1,ind2,dp,word1,word2),findLcs(ind1,ind2-1,dp,word1,word2));

        return dp[ind1][ind2]; 
    }
    public int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }

        int lcs = findLcs(n1-1,n2-1,dp,word1,word2);

        int ans = n1+n2-(2*lcs);
        return ans;
        
    }
}