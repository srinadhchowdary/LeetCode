class Solution {
    public int lastStoneWeightII(int[] nums) {

        int n= nums.length;

        int tsum =0,psum=0,nsum=0;

        for(int ele:nums){
            tsum+=ele;
            if(ele>=0){
                psum+=ele;
            }
            else{
                nsum+=ele;
            }
        }

        int offset = -nsum;
        int range = psum+offset+1;

        boolean dp[][]=new boolean[n][range];

        for(int i=0;i<n;i++){
            dp[i][offset] = true;
        }

        dp[0][offset+nums[0]] = true;

        for(int i=1;i<n;i++){
            for(int target=nsum;target<=psum;target++){
                int ind = offset+target;
                boolean skip = dp[i-1][ind];

                int remainingsum = target - nums[i];
                boolean take = false;
                if(remainingsum >=nsum && remainingsum<=psum){
                    take = dp[i-1][offset+remainingsum];
                }

                dp[i][target] = skip | take;
            }
        }

        int mini=Integer.MAX_VALUE;
        for(int s1=nsum;s1<=psum;s1++){
            if(dp[n-1][offset+s1]){
                int s2 = tsum-s1;
                int diff = Math.abs(s1-s2);
                mini = Math.min(mini,diff);
            }
            
        }
        return mini;
    }
}