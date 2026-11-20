class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer>st =new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            st.add(nums1[i]);
        }

        int arr[]=new int[Math.min(nums1.length,nums2.length)];
        int j=0;

        for(int i=0;i<nums2.length;i++){
            if(st.contains(nums2[i])){
                arr[j] = nums2[i];
                j++;
                st.remove(nums2[i]);
            }
        }
        
       
        
        return Arrays.copyOf(arr,j);
    }
}