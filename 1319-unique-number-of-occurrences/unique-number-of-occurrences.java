class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        int n = arr.length;
        
        int[] freq = new int[2001];

        for (int num : arr) {
            int index = num + 1000;
            freq[index]++;
        }

        Set<Integer> s = new HashSet<>();

        for(int i=0;i<2001;i++){

            if(freq[i] != 0){
                if(s.contains(freq[i])){
                    return false;
                }
                s.add(freq[i]);
            }
        }

    return true;
    }
}