
class Solution {

    // space optimisation
    // TC : O(N)
    // SC : O(N)
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] front1 = new int[2]; // ind + 1
        int[] front2 = new int[2]; // ind + 2
        int[] curr = new int[2];

        for (int ind = n - 1; ind >= 0; ind--) {

            // Can buy
            curr[1] = Math.max(
                -prices[ind] + front1[0],
                front1[1]
            );

            // Can sell (cooldown after selling)
            curr[0] = Math.max(
                prices[ind] + front2[1],
                front1[0]
            );

            // Shift states
            front2[0] = front1[0];
            front2[1] = front1[1];

            front1[0] = curr[0];
            front1[1] = curr[1];
        }

        return front1[1];
    }
}
