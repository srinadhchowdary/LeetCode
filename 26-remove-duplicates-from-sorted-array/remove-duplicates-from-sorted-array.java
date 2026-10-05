class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=nums[j]){
                j++;
                int temp = nums[j];
                nums[j]= nums[i];
                nums[i]=temp;
            }
        }
        return j+1;
    }
}