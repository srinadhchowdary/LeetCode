class Solution {

    // Memoisation
    // Time complexity : Nx2x3
    // Space Complexity : O(Nx2x3) + O(N)

    public int findProfit(int ind,int buy,int[][][] dp,int[] prices, int n,int cap){

        if(ind == n)return 0;
        if(cap == 0) return 0;

        if(dp[ind][buy][cap] != -1)return dp[ind][buy][cap];

        int money = 0;

        if(buy == 1){
            money = Math.max(-prices[ind]+findProfit(ind+1,0,dp,prices,n,cap),
                             0+findProfit(ind+1,1,dp,prices,n,cap));
        }
        else{
            money = Math.max(+prices[ind]+findProfit(ind+1,1,dp,prices,n,cap-1),
                            0+findProfit(ind+1,0,dp,prices,n,cap));
        }

        dp[ind][buy][cap] = money;

        return dp[ind][buy][cap];

    }
    public int maxProfit(int[] prices) {

        int dp[][][] = new int[prices.length][2][3];

        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return findProfit(0,1,dp,prices,prices.length,2);

    }
}