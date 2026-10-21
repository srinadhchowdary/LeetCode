class Solution {

    public static int upperbound(int nums[],int ele,int arr1[]){

        int low=0,high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr1[mid]>=ele){
                
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int n=nums.length;

        int arr[]=new int[n];

        int arr1[]=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            arr1[i]=nums[i];
        }

        Arrays.sort(arr1);


        for(int i=0;i<n;i++){
            arr[i]=upperbound(nums,nums[i],arr1);
        }
        return arr;
        
    }
}