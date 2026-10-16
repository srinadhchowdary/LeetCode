class Solution {

    public int minCostToMoveChips(int[] nums) {

        int even = 0,odd = 0;

        for(int num:nums){
            if(num %2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }
        int n = nums.length;
        int ans = 0;
        if(odd > even){
            ans += even;
        }
        else{
            ans += odd;
        }
        return ans;
        
    }
}