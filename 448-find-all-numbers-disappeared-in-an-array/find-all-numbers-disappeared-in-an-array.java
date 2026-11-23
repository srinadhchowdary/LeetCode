class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;


        int arr[]=new int[n+1];

        for(int i=0;i<n;i++){
            arr[nums[i]]=1;
        }

        List<Integer>l = new ArrayList<>();

        for(int i=1;i<=n;i++){
            if(arr[i]!= 1){
                l.add(i);
            }
        }

        return l;
        
    }
}