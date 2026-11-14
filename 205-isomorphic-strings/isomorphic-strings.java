class Solution {
    public boolean isIsomorphic(String s, String t) {


        int n1 =s.length();
        int n2 = t.length();

        int arr[]=new int[128];
        int arr1[]=new int[128];

        for(int i=0;i<n1;i++){

            int ind1 = s.charAt(i);
            int ind2 = t.charAt(i);

            if(arr[ind1] != arr1[ind2]){
                return false;
            }

            arr[ind1] = i+1;;
            arr1[ind2] = i+1;
        }
    return true;
        
    }
}