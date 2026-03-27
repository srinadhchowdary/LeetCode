class Solution {

    public void left(int ans[],int k){
        int n= ans.length;
        while(k>0){
            int temp = ans[0];
            for(int i=1;i<n;i++){
                ans[i-1]= ans[i];
            }
            ans[n-1]= temp;
            k--;
        }
    }

    public void right(int[] ans,int k){
        int n = ans.length;
        while(k>0){

            int temp = ans[n-1];
            for(int i=n-1;i>0;i--){
                ans[i]= ans[i-1];
            }
            ans[0]=temp;
            k--;
        }
    }

    public boolean areSimilar(int[][] mat, int k) {

        int n = mat.length;
        int m = mat[0].length;

        if(k> m){
            k = k%m;
        }

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = mat[i][j];
            }
        }
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                left(ans[i],k);
            }
            else{
                right(ans[i],k);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] != ans[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}