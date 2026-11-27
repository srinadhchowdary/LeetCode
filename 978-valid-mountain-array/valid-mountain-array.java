class Solution {
    public boolean validMountainArray(int[] arr) {

        int n= arr.length;
        int i=0,j=n-1;

        if(n<3)return false;

        while(i<n-1 && arr[i]<arr[i+1]){
            i++;
        }

        if(i==0 || i==n - 1) return false;

        while(i<n-1 && arr[i]>arr[i+1]){
            i++;
        }

        if(i==n-1)return true;
        return false;
        
    }
}