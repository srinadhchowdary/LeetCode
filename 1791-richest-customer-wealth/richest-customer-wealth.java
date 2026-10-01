class Solution {
    public int maximumWealth(int[][] accounts) {

        int sum =0;
        
        int m= accounts.length;
        int n = accounts[0].length;
        for(int i=0;i<m;i++){
            int total = 0;
            for(int j=0;j<n;j++){
                total += accounts[i][j];
            }
            sum = Math.max(sum,total);
        }
        return sum;
        
    }
}