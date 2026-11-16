class Solution {

    // Tabulation
    // Time complexity : O(NxM);
    // Space complexity : O(NxM)


    public int minDistance(String word1, String word2) {


        int n1 =word1.length();
        int n2 = word2.length();
        int dp[]=new int[n2+1];


        for(int j=0;j<=n2;j++){
            dp[j] = j;
        }

        for(int i=1;i<=n1;i++){
            int curr[]=new int[n2+1];
            curr[0]=i;

            for(int j=1;j<=n2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j] = dp[j-1];
                }
                else{
                    int replace = 1+dp[j-1];
                    int delete = 1+dp[j];
                    int insert = 1+curr[j-1];

                    curr[j] = Math.min(insert,Math.min(delete,replace));
                }
            }
            dp = curr;
        }

        return dp[n2];
        
    }
}