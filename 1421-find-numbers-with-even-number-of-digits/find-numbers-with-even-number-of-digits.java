class Solution {
    public int findNumbers(int[] nums) {

        long ans = Arrays.stream(nums)
            .filter(num -> String.valueOf(num).length()%2 == 0 )
            .count();

        return (int)ans;
    }
}