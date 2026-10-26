class Solution {

    public boolean check(int nums[],int ind){
        int count = 0;

        while( ind>0){
            int rem = ind%10;
            count++;
            ind = ind/10;
            

        }

        if(count %2 == 0)return true;
        return false;
    }
    public int findNumbers(int[] nums) {

        int n = nums.length;
        int count=0;

        for(int i=0;i<n;i++){
            if(check(nums,nums[i])){
                count++;
            }
        }
        
    return count;

    }
}