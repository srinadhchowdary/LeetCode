class Solution {
    public int minCostToMoveChips(int[] position) {

        int min = Integer.MAX_VALUE;
        int n= position.length;
        for(int i=0;i<n;i++){
            int ans=0;
            for(int j=0;j<n;j++){

                if((position[i]%2==0 && position[j]%2==0) || (position[i]%2==1 && position[j]%2==1)){
                    ans = ans;
                }
                else{
                    ans++;
                }
            }
            min = Math.min(min,ans);
        }
        return min;
    }
}