class Solution {

    // Memoisation
    // Time Complexity : O(N×target)
    // Space Complexity : O(n×target) + O(n)

    public boolean findTarget(int ind,int target,int nums[],Boolean dp[][]){

        if(target == 0)return true;
        if(ind == 0) return nums[ind] == target;
        if(dp[ind][target] != null)return dp[ind][target];

        boolean skip = findTarget(ind-1,target,nums,dp);
        boolean take = false;
        if(nums[ind]<= target){
            take = findTarget(ind-1,target-nums[ind],nums,dp);
        }

        dp[ind][target] = take | skip;

        return dp[ind][target];
    }
    public boolean canPartition(int[] nums) {

        int n= nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum %2 ==1)return false;
        

        int target = sum/2;
        Boolean dp[][]=new Boolean[n][target+1];
        return findTarget(n-1,target,nums,dp);
        
    }
}