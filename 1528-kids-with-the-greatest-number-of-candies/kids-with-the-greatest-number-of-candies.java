class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> l = new ArrayList<>();

        int maxi =Integer.MIN_VALUE;

        for(int i:candies){
            maxi = Math.max(maxi,i);
        }

        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies >= maxi){
                l.add(true);
            }
            else{
                l.add(false);
            }
        }
        return l;
    }
}