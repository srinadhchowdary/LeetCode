class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int n= nums.length,i=0,j=n-1;

        int ans[]=new int[n];
        int x = 0;

        while(x<n){
            if(nums[x]%2 == 0){
                ans[i]= nums[x];
                i++;
            }
            else{
                ans[j] = nums[x];
                j--;
            }
            x++;
        }

        return ans;
  
    }
}