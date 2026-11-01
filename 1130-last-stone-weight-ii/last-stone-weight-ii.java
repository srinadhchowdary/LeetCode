class Solution {

    // Space Optimisation
    // Time Complexity : O(NxS)
    // Space Complexity : O(N)

    public int lastStoneWeightII(int[] stones) {

        int totalSum = 0;

        for(int stone : stones) {
            totalSum += stone;
        }

        int limit = totalSum / 2;

        boolean[] dp = new boolean[limit+1];

        dp[0] = true;

        for(int i = 0; i < stones.length; i++) {

            for(int target = limit; target >= stones[i]; target--) {

                dp[target] = dp[target] ||
                             dp[target-stones[i]];
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for(int s1 = 0; s1 <= limit; s1++) {

            if(dp[s1]) {

                int s2 = totalSum-s1;

                minDiff = Math.min(minDiff, s2-s1);
            }
        }

        return minDiff;
    }
}