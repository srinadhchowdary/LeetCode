class Solution {

    // Memoisation 
    // Time complexity : N×2×(K+1)]×O(1)= O(NK)
    // Space Complexity : O(Nx2xK+1) + O(N)
 

    public int findProfit(int ind,int buy,int cap,int[] prices,int[][][] dp,int n){

        if(ind == n) return 0;
        if(cap == 0)return 0;

        if(dp[ind][buy][cap] != -1)return dp[ind][buy][cap];

        int money = 0;
        if(buy == 1){
            money = Math.max(-prices[ind]+findProfit(ind+1,0,cap,prices,dp,n),
                             0+findProfit(ind+1,1,cap,prices,dp,n));
        }
        else{
            money = Math.max(+prices[ind]+findProfit(ind+1,1,cap-1,prices,dp,n),
                             0+findProfit(ind+1,0,cap,prices,dp,n));
        }

        dp[ind][buy][cap] = money;

        return dp[ind][buy][cap];
    }
    public int maxProfit(int k, int[] prices) {

        int n= prices.length;
        int dp[][][] = new int[n][2][k+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return findProfit(0,1,k,prices,dp,n);
        
    }
}