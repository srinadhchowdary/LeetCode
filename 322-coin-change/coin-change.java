class Solution {

    // Memoisation
    // Time complexity : O(N x amount)
    // Space complexity : O(N X amount)

    public int denomination(int ind,int target,int[] coins,int[][]dp){
        
        if(ind == 0){
            if(target % coins[ind] == 0)return target/coins[ind];
            return 1000000;
        }

        if(dp[ind][target] != -1)return dp[ind][target];

        int skip = 0+ denomination(ind-1,target,coins,dp);
        int take = 1000000;
        if(target >= coins[ind]){
            take = 1+denomination(ind,target-coins[ind],coins,dp);
        }

        dp[ind][target] = Math.min(skip,take);
        return dp[ind][target];
    }
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans =  denomination(n-1,amount,coins,dp);
        return ans >= 1000000 ? -1 : ans;
        
    }
}