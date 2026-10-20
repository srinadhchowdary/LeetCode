class Solution {

    // Space Optimisation
    // Time complexity : O(Nx2x2) ~ O(N)
    // Space Complexity : O(2x3) = O(6) ~ O(N)

    
    public int maxProfit(int[] prices) {

        int after[][] = new int[2][3];
        int curr[][] = new int[2][3];

        for(int ind=prices.length-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                // cap = 0 then return 0 so dp[?][?][0] = 0
                int money = 0;
                for(int cap = 1;cap<=2;cap++){
                    
                    if(buy == 1){
                        money = Math.max(-prices[ind]+after[0][cap],
                            0+after[1][cap]);
                        }
                    else{
                        money = Math.max(+prices[ind]+after[1][cap-1],
                            0+after[0][cap]);
                        }

                    curr[buy][cap] = money;
                }
                after = curr;
            }
        }

        return after[1][2];

    }
}