class Solution {

    // Space Optimisation 
    // Time complexity : O((N+1)×2×K)
    // Space Complexity : O(2×(K+1))
 
    public int maxProfit(int k, int[] prices) {

        int n= prices.length;
        int after[][] = new int[2][k+1];
        int curr[][] = new int[2][k+1];


        for(int ind = n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                int money=0;
                for(int cap = 1;cap<=k;cap++){
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
        return after[1][k];

    }
}