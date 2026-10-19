class Solution {

    // Tabulation
    // Time complexity :
    // Space Complexity : 

    
    public int maxProfit(int[] prices) {

        int dp[][][] = new int[prices.length+1][2][3];

        for(int ind=prices.length-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                // cap = 0 then return 0 so dp[?][?][0] = 0
                int money = 0;
                for(int cap = 1;cap<=2;cap++){
                    
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

        return dp[0][1][2];

    }
}