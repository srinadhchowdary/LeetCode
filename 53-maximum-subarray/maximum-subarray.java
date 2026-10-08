class Solution {

    public int solve(int nums[],int i,int[]dp){

        if(i==0) return nums[0];
        if(dp[i] != -1)return dp[i];
        dp[i] = Math.max(nums[i],nums[i]+solve(nums,i-1,dp));
        return dp[i];
    }
    public int maxSubArray(int[] nums) {

        int n= nums.length;
        int ans = Integer.MIN_VALUE;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            ans = Math.max(ans,solve(nums,i,dp));
        }
        return ans;
        
    }
}