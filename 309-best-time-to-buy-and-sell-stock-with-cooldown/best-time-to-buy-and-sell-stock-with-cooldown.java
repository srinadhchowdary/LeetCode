class Solution {

    // Tabulation 
    // Time complexity : O((Nx2)
    // Space Complexity : O((N+2)x2)

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int after[][] = new int[n+2][2];

        int curr[][] = new int[n+2][2];

        for(int ind=n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                int money = 0;

                if(buy == 1){

                    money = Math.max(-prices[ind]+after[ind+1][0],
                                    0+after[ind+1][1]);
                }
                else{
                    money = Math.max(+prices[ind]+after[ind+2][1],
                                    0+after[ind+1][0]);
                }

                curr[ind][buy] = money;
            }

            after = curr;
        }
        
        return after[0][1];
        
    }
}