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

        for(int s:s1){
            if(!s2.contains(s) ){
                l1.add(s);
            }
        }

         for(int s:s2){
            if(!s1.contains(s)){
                l2.add(s);
            }
        }

        l.add(l1);
        l.add(l2);
        return l;

        


        
    }
}