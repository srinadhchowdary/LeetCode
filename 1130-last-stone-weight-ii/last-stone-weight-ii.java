class Solution {

    // Memoisation
    // Time complexity : O(NxS)
    // Space complexity : O(NxS)

    public boolean solve(
        int ind,
        int target,
        int[] stones,
        int[][] dp
    ) {

        if(target == 0) return true;

        if(ind == 0) {
            return stones[0] == target;
        }

        if(dp[ind][target] != -1) {
            return dp[ind][target] == 1;
        }

        boolean skip = solve(ind-1, target, stones, dp);

        boolean take = false;

        if(target >= stones[ind]) {
            take = solve(ind-1, target-stones[ind], stones, dp);
        }

        dp[ind][target] = (skip || take) ? 1 : 0;

        return dp[ind][target] == 1;
    }

    public int lastStoneWeightII(int[] stones) {

        int n = stones.length;

        int totalSum = 0;

        for(int stone : stones) {
            totalSum += stone;
        }

        int limit = totalSum / 2;

        int[][] dp = new int[n][limit+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int minDiff = Integer.MAX_VALUE;

        for(int s1 = 0; s1 <= limit; s1++) {

            if(solve(n-1, s1, stones, dp)) {

                int s2 = totalSum-s1;

                minDiff = Math.min(minDiff, s2-s1);
            }
        }

        return minDiff;
    }
}