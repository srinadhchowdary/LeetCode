class Solution {
    public boolean isIsomorphic(String s, String t) {


        int n1 = s.length(),n2 = t.length();

        int arr1[] = new int[128];
        int arr2[]=new int[128];

        Arrays.fill(arr1,-1);
        Arrays.fill(arr2,-1);

        for(int i=0;i<n1;i++){

            int ind1 = s.charAt(i);
            int ind2 = t.charAt(i);

            if(arr1[ind1] != arr2[ind2])return false;


            arr1[ind1] = i;
            arr2[ind2] = i;
        }

        return true;
    }
}