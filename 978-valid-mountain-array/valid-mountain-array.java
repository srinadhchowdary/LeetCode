class Solution {
    public boolean validMountainArray(int[] arr) {

        int n= arr.length;
        int i=0,j=n-1;

        if(n<3)return false;

        while(i<n-1 && arr[i]<arr[i+1]){
            i++;
        }

        while(j>0  && arr[j]<arr[j-1]){
            j--;
        }

        if(i==j && i != 0 && j != n - 1){
            return true;
        }
        return false;
        
    }
}