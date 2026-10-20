class Solution {

    // Memoisation 
    // Time complexity : O(Nx2)
    // Space Complexity : O(Nx2)+O(N) // Auxilary space

    public int findProfit(int ind,int buy,int[] prices,int[][] dp,int n){
        
        if(ind >= n)return 0;

        if(dp[ind][buy] != -1)return dp[ind][buy];
        int money = 0;
        if(buy == 1){

            money = Math.max(-prices[ind]+findProfit(ind+1,0,prices,dp,n),
                            0+findProfit(ind+1,1,prices,dp,n));
        }
        else{
            money = Math.max(+prices[ind]+findProfit(ind+2,1,prices,dp,n),
                            0+findProfit(ind+1,0,prices,dp,n));
        }

        dp[ind][buy] = money;

        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int dp[][] = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return findProfit(0,1,prices,dp,n);
        
    }
}