public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // if(n == 0)
        //     return 0;
        // String first = Integer.toBinaryString(n);
        // StringBuilder sb = new StringBuilder(first);
        // while(sb.length() < 32)
        //     sb.insert(0, "0");
        // String ans = sb.reverse().toString();
        // System.out.println(ans);
        // if(ans.charAt(0) == '1')
        //     ans="-"+ans;
        // System.out.println(ans);
        // return (int)Long.parseLong(ans,2);
        int res = 0;
        for(int i = 0; i < 32; i++)
        {
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;
        }
        return res;
    }
}