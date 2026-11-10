class Solution {
    public int[] numberOfPairs(int[] nums) {

        int n = nums.length;
        int hash[]=new int[101];

        for(int i=0;i<n;i++){
            hash[nums[i]]++;
        }

        int pairs = 0,nonpairs = 0;

        for(int i=0;i<101;i++){
            if(hash[i]%2 == 0){
                pairs += hash[i]/2;
            }
            else{
                pairs += hash[i]/2;
                nonpairs++;
            }
        }
        
        return new int[]{pairs,nonpairs};
        
    }
}