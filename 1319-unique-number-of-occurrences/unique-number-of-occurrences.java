class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        int n = arr.length;
        
        int[] freq = new int[2001];

        for (int num : arr) {
            int index = num + 1000;
            freq[index]++;
        }

        for(int i=0;i<n;i++){

            int num = arr[i];
            int index = num+1000;
            int freq1 = freq[index];

            for(int j=0;j<2001;j++){
                int num1 = j-1000;
                int freq2 = freq[j];

                if(num != num1 && freq2>0 && freq1 == freq2){
                    return false;
                }
            }
        }

    return true;
    }
}