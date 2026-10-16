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
        int ele = 0;
        if(even > odd){
            int count=0;
            for(int num:nums){
                if(num %2 == 0){
                    if(count == 0){ele = num;}
                    if(ele == num)count++;
                    else count--;     
                }
            }
        }
        else{
            int count=0;
            for(int num:nums){
                if(num %2 == 1){
                    if(count == 0){ele = num;}
                    if(ele == num)count++;
                    else count--;     
                }
            }
        }

        int ans = 0;
        for(int num:nums){
            if((num %2== 0 && ele %2 == 0) || (num%2==1 && ele%2==1)){
                ans = ans;
            }
            else{
                ans++;
            }
        }

        return ans;
        
    }
}