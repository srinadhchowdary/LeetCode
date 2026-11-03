class Solution {

    // Space Optimisation
    // Time complexity : O(N x amount)
    // Space complexity : O(N)

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int dp[]=new int[amount+1];
        for(int t= 0;t<=amount;t++){
            if(t % coins[0] == 0){
                dp[t] = t/coins[0];
            }
            else{
                dp[t] = 1000000;
            }
        }

        for(int ind=1;ind<n;ind++){
            int curr[]=new int[amount+1];
            for(int target = 0;target<amount+1;target++){

                int skip = 0+ dp[target];
                int take = 1000000;
                if(target >= coins[ind]){
                    take = 1+curr[target-coins[ind]];
                }

                curr[target] = Math.min(skip,take);

            }
            dp = curr;
        }
        
        int ans =  dp[amount];
        return ans >= 1000000 ? -1 : ans;
        
    }
}