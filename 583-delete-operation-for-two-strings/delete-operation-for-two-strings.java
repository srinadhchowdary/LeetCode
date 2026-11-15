class Solution {

    public int findLcs(int ind1,int ind2,int[][] dp,String word1,String word2){

        if(ind1 <0 || ind2<0)return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        

        return dp[ind1][ind2]; 
    }
    public int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        int dp[] = new int[n2+1];

        for(int i=0;i<n2+1;i++){
            dp[i] = 0;
        }
   

        for(int i=1;i<=n1;i++){
            int curr[]=new int[n2+1];
            for(int j=1;j<=n2;j++){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] =  1+ dp[j-1];
                }
                else{
                    curr[j] = Math.max(dp[j],curr[j-1]);
                }
            }
            dp = curr;
        }
        int lcs = dp[n2];
        int ans = n1+n2-(2*lcs);
        return ans;
        
    }
}