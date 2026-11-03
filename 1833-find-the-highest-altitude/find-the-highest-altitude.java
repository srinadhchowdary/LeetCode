class Solution {
    public int largestAltitude(int[] gain) {

        
        int sum = 0;

        int n = gain.length;

        int prefix[]=new int[n+1];
        prefix[0] = 0;
        for(int i=0;i<n;i++){
            sum +=gain[i];
            prefix[i+1] = sum;
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n+1;i++){
            maxi= Math.max(maxi,prefix[i]);
        }

        return maxi;
    }
}