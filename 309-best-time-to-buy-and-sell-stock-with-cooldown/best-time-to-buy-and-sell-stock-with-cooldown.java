class Solution {

    // Tabulation 
    // Time complexity : O((Nx2)
    // Space Complexity : O((N+2)x2)

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int dp[][] = new int[n+2][2];


        for(int ind=n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                int money = 0;

                if(buy == 1){

                    money = Math.max(-prices[ind]+dp[ind+1][0],
                                    0+dp[ind+1][1]);
                }
                else{
                    money = Math.max(+prices[ind]+dp[ind+2][1],
                                    0+dp[ind+1][0]);
                }

                dp[ind][buy] = money;
            }

        }
        
        return dp[0][1];
        
    }
}