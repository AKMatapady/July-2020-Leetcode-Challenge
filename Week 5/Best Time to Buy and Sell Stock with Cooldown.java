class Solution {
    public int maxProfit(int[] prices) {
        //dp[x][0]  -> you do not poccess a stock on day x
        //dp[x][1]   -> you have a stock on day x
        if(prices == null || prices.length < 2)
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = (-prices[0]);
        dp[1][0] = Math.max(0, dp[0][1]+prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for(int i = 2; i < len; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
        }
        return dp[len-1][0];
    }
}