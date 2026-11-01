class Solution {


    public int lastStoneWeightII(int[] nums) {

        // negsum <= target <= possum

        int n= nums.length;
        int totalsum = 0,negsum=0,possum=0;

        for(int i=0;i<n;i++){
            totalsum+=nums[i];
            if(nums[i]>=0){
                possum +=nums[i];
            }
            else{
                negsum+=nums[i];
            }
        }

        int offset = -negsum;
        int range = possum+offset+1;
        boolean[][] dp = new boolean[n][range];

        for(int i=0;i<n;i++){
            dp[i][offset] = true;
        }

        dp[0][nums[0]+offset] = true;

        for(int i=1;i<n;i++){
            for(int target=negsum;target<possum+1;target++){

                int ind = offset + target; 

                boolean skip = dp[i-1][ind];

                int remainingsum = target - nums[i];
                boolean take = false;
                if(remainingsum >= negsum && remainingsum <= possum){
                    ind = offset+remainingsum;
                    take = dp[i-1][ind];
                }

                dp[i][target] = skip | take;
                
            }
        }

        int mindiff = Integer.MAX_VALUE;
        for(int s1 = negsum ;s1<=possum;s1++){
            if(dp[n-1][offset+s1]){
                int s2 = totalsum - s1;
                int diff = Math.abs(s1-s2);
                mindiff = Math.min(mindiff,diff);
            }
        }
        return mindiff;
    }
}