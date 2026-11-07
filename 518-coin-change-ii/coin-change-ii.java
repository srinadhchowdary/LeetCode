class Solution {

    // Space Optimisation
    //Time complexity : O(Target)
    //Space complexity : O(Target)

    public int change(int amount, int[] coins) {
        int n= coins.length;
        int dp[]=new int[amount+1];

        for(int T=0;T<=amount;T++){
            if(T%coins[0] == 0){
                dp[T] = 1;
            }
            else{
                dp[T] = 0;
            }
        }

        for(int ind = 1;ind < n;ind++){
            int curr[]=new int[amount+1];
            for(int target=0;target<=amount;target++){

                int skip = dp[target];
                int take = 0;
                if(coins[ind] <= target){
                    take = curr[target-coins[ind]];
                }
                curr[target] =  skip+take;
            }
            dp=curr;
        }
        
        return dp[amount];
    }
}