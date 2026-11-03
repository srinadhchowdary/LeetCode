class Solution {

    // Tabulation
    // Time complexity : O(N x amount)
    // Space complexity : O(N X amount)

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int dp[][]=new int[n][amount+1];
        for(int t= 0;t<=amount;t++){
            if(t % coins[0] == 0){
                dp[0][t] = t/coins[0];
            }
            else{
                dp[0][t] = 1000000;
            }
        }

        for(int ind=1;ind<n;ind++){
            for(int target = 0;target<amount+1;target++){

                int skip = 0+ dp[ind-1][target];
                int take = 1000000;
                if(target >= coins[ind]){
                    take = 1+dp[ind][target-coins[ind]];
                }

                dp[ind][target] = Math.min(skip,take);

            }
        }
        
        int ans =  dp[n-1][amount];
        return ans >= 1000000 ? -1 : ans;
        
    }
}