class Solution {
    public int pivotIndex(int[] nums) {

        int n= nums.length;
        int totalsum =0;
        
        for(int i=0;i<n;i++){
            totalsum+=nums[i];
        }

        int lsum = 0;

        for(int i=0;i<n;i++){

            int rsum = totalsum - nums[i] - lsum;

            if(rsum == lsum){
                return i;
            }
            lsum += nums[i];
        }
return -1;

    }
}