class Solution {
    public int arrangeCoins(int n) {
        long sum = 0;
        int i = 0;
        while(sum <= n)
        {
            i++;
            sum += i;
        }
        return i-1;
    }
}