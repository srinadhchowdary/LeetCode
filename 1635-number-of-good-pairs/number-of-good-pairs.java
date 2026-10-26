class Solution {
    public int numIdenticalPairs(int[] nums) {

        int count =0,n= nums.length;

        int arr[]=new int[101];
        Arrays.fill(arr,0);

        for(int i=0;i<n;i++){
            count += arr[nums[i]];
            arr[nums[i]]++;
        }
        
        return count;
    }
}