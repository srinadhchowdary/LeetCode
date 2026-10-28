class Solution {

/*
    // Tabulation
    // Time Complexity : N * 2 = O(2N) ~ O(N)
    // Space Complexity : S(N)=(N+1)×2 ~O(N)
​
    */


    public int maxProfit(int[] prices, int fee) {

        int n= prices.length;

        int dp[][]=new int[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int i=n-1;i>=0;i--){
            for(int buy = 0;buy<2;buy++){

                int money =0;
                if(buy == 1){

                    money = Math.max(-prices[i]+dp[i+1][0],
                            0+dp[i+1][1]);
                            
                }
                else{
                    money = Math.max(+prices[i]-fee+dp[i+1][1],
                                    0+dp[i+1][0]);
                }
                dp[i][buy] = money;

            }
        }
        
        return dp[0][1];
        
    }
}