class Solution {

    // Tabulation
    //Time complexity : O(NxTarget)
    //Space complexity : O(NxTarget)

    public int change(int amount, int[] coins) {
        int n= coins.length;
        int dp[][]=new int[n][amount+1];

        for(int T=0;T<=amount;T++){
            if(T%coins[0] == 0){
                dp[0][T] = 1;
            }
            else{
                dp[0][T] = 0;
            }
        }

        for(int ind = 1;ind < n;ind++){
            for(int target=0;target<=amount;target++){

                int skip = dp[ind-1][target];
                int take = 0;
                if(coins[ind] <= target){
                    take = dp[ind][target-coins[ind]];
                }
                dp[ind][target] =  skip+take;

            }
        }
        
        return dp[n-1][amount];
    }
}