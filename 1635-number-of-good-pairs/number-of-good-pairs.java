class Solution {
    public int numIdenticalPairs(int[] nums) {

        int count =0,n= nums.length;

        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            if(mp.containsKey(nums[i])){
                count=count+ mp.get(nums[i]);
                mp.put(nums[i],mp.get(nums[i])+1);

            }
            else{
                mp.put(nums[i],1);
            }
        }
        
        return count;
    }
}