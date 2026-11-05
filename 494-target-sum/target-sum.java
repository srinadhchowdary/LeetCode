class Solution {


    public static int solve(int ind,int target,int[]arr){
        
        
        if(ind == 0){
            
            if(target == 0 && arr[ind]==0)return 2;
            
            if(target == 0 || arr[ind]==target)return 1;
            
            return 0;
        }
        
        int skip = solve(ind-1,target,arr);
        int take = 0;
        
        if(arr[ind]<=target){
            take = solve(ind-1,target-arr[ind],arr);
        }
        
        return skip + take;
        
    }
    public int countPartitions(int[] arr, int diff) {
        // code here
        
        int n = arr.length;
        
        int tsum = 0;
        for(int i=0;i<n;i++){
            tsum+=arr[i];
        }
        
        if(tsum <diff)return 0;
        
        if((tsum+diff)%2 != 0) return 0;
        
        int target = (tsum+diff)/2;
        
        return solve(n-1,target,arr);
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums,target);
    }
}