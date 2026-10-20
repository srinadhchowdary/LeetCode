class Solution {

    // Tabulation 
    // Time complexity : O((N+1)×2×K)
    // Space Complexity : O((N+1)×2×(K+1))
 
    public int maxProfit(int k, int[] prices) {

        int n= prices.length;
        int dp[][][] = new int[n+1][2][k+1];

        for(int ind = n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                int money=0;
                for(int cap = 1;cap<=k;cap++){
                    if(buy == 1){
                        money = Math.max(-prices[ind]+dp[ind+1][0][cap],
                                        0+dp[ind+1][1][cap]);
                        }
                    else{
                        money = Math.max(+prices[ind]+dp[ind+1][1][cap-1],
                                     0+dp[ind+1][0][cap]);
                        }
                        dp[ind][buy][cap] = money;
                }
            }
        }
        return dp[0][1][k];

    }
}