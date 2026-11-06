class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> l = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        Set<Integer>s1= new HashSet<>();
        Set<Integer>s2= new HashSet<>();


        for(int i=0;i<nums1.length;i++){
            s1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            s2.add(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            if(!s2.contains(nums1[i]) && !l1.contains(nums1[i])){
                l1.add(nums1[i]);
            }
        }

         for(int i=0;i<nums2.length;i++){
            if(!s1.contains(nums2[i]) && !l2.contains(nums2[i])){
                l2.add(nums2[i]);
            }
        }

        l.add(l1);
        l.add(l2);
        return l;

        


        
    }
}