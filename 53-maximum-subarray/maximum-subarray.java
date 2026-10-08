class Solution {

    public int maxSubArray(int[] nums) {

        int n= nums.length;
        int ans = Integer.MIN_VALUE;
        int dp[]=new int[n];
        dp[0]=nums[0];
        ans =Math.max(ans,dp[0]);
        for(int i=1;i<n;i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
        
    }
}