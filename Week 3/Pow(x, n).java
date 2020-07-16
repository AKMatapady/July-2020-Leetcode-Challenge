class Solution {
    public double myPow(double x, int n) {
        if(x == 1 || n == 0)
            return 1.0;
        if(x == 0)
            return 0.0;
        if(x == -1)
            return (n%2==0)?(1.0):(-1.0);
        double ans = 1;
        // boolean reciprocal = false;
        // if(n < 0)
        //     reciprocal = true;
        // n = Math.abs(n);
        if(n > 0)
            while(n > 0)
            {
                n--;
                ans *= x;
            }
        // if(reciprocal)
        //     ans = (1/ans);
        if(n < 0)
            while(n <0 && ans != 0)
            {
                n++;
                ans /= x;
            }
        return ans;
    }
}