class Solution {
    public int nthUglyNumber(int n) {
        if(n < 1)
            return 0;
        if( n == 1)
            return 1;
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n-1];
        dp[0] = 1;
        for(int i = 1; i < n-1; i++)
        {
            int next = Math.min(dp[a]*2, Math.min(dp[b]*3, dp[c]*5));
            dp[i] = next;
            if(next == (dp[a]*2))
                a++;
            if(next == (dp[b]*3))
                b++;
            if(next == (dp[c]*5))
                c++;               
            //System.out.println("a: " + a + ", b: " + b + ", c: " + c);
            //System.out.println(i + ": " + dp[i]);
        }
        return Math.min(dp[a]*2, Math.min(dp[b]*3, dp[c]*5));
    }
}