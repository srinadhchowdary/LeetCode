class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int n1 = ransomNote.length() , n2 = magazine.length();

        int arr[]=new int[26];
        for(int i=0;i<n2;i++){
            arr[magazine.charAt(i)-'a']++;
        }

        for(int i=0;i<n1;i++){
            if(arr[ransomNote.charAt(i)-'a'] ==0){
                return false;
            }
            arr[ransomNote.charAt(i)-'a']--;

        }

        return true;
    }
}