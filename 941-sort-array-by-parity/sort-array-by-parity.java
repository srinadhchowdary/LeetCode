class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int n= nums.length,i=0,j=n-1;

        while(i<j){
            if(nums[i]%2==0){
                i++;
            }
            else if(nums[j]%2!=0){
                j--;
            }
            else{

                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
            }
        }

        return nums;
  
    }
}