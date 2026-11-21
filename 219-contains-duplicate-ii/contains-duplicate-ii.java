class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer>mp =new HashMap<>();
        int n= nums.length;

        for(int i=0;i<n;i++){
            if(mp.containsKey(nums[i])){
                int index = mp.get(nums[i]);
                if(Math.abs(index-i) <=k)return true;
            }
            mp.put(nums[i],i);
        }

        return false;
        
    }
}