class Solution {

/*
    // Memoisation
    // Time Complexity : 
    T(N) = Number of states×Work per state
        =O(2N)×O(1)
        = O(N)
​
    // Space Complexity : 

            S(N)=O(N)+O(N) ( dp array + Recursion stack)
                = O(N) 
​
    */

    public int findProfit(int ind,int buy,int fee,int n,int prices[],int[][] dp){

        if(ind == n)return 0;

        if(dp[ind][buy] != -1)return dp[ind][buy];
        int money =0;
        if(buy == 1){

            money = Math.max(-prices[ind]+findProfit(ind+1,0,fee,n,prices,dp),
                    0+findProfit(ind+1,1,fee,n,prices,dp));
                    
        }
        else{
            money = Math.max(+prices[ind]-fee+findProfit(ind+1,1,fee,n,prices,dp),
                            0+findProfit(ind+1,0,fee,n,prices,dp));
        }

        dp[ind][buy] = money;

        return dp[ind][buy];
    }
    public int maxProfit(int[] prices, int fee) {

        int n= prices.length;

        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return findProfit(0,1,fee,n,prices,dp);
        
    }
}