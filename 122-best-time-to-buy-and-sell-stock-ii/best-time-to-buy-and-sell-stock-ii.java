class Solution {

    // Memoization
    // Time complexity : O(Nx2) (for every index take or not take)
    // Space Complexity : O(Nx2) + O(n) (Auxilary Stack space)

    public int findProfit(int i,int canBuy, int dp[][], int[] prices,int n){

        if(i == n)return 0;

        if(dp[i][canBuy] != -1)return dp[i][canBuy];

        int money = 0;
        if(canBuy == 1){
            money = Math.max(-prices[i]+findProfit(i+1,0,dp,prices,n),
                            0+findProfit(i+1,1,dp,prices,n));
        }
        else{
            money = Math.max(+prices[i]+findProfit(i+1,1,dp,prices,n),
                            0+findProfit(i+1,0,dp,prices,n));
        }

        dp[i][canBuy] = money;

        return dp[i][canBuy];
    }
    public int maxProfit(int[] prices) {

        int dp[][] = new int[prices.length][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return findProfit(0,1,dp,prices,prices.length);
        
    }
}