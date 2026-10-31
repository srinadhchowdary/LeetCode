class Solution {

    // Space Optimisation
    // Time Complexity : 
    // Space Complexity :  

    
    public boolean canPartition(int[] nums) {

        int n= nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum %2 ==1)return false;
        

        int target = sum/2;
        boolean prev[]=new boolean[target+1];
        prev[0] = true;


        if(nums[0] <= target){
            prev[nums[0]] = true;
        }

        for(int i=1;i<n;i++){
            boolean curr[]=new boolean[target+1];
            for(int tar = 1;tar<target+1;tar++){

                boolean skip = prev[tar];
                boolean take = false;
                if(nums[i]<= tar){
                    take = prev[tar-nums[i]];
                }
                curr[tar] = take | skip;               
                }
                prev= curr;
            }


        return prev[target];
        
    }
}