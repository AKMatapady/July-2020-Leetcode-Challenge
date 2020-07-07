class Solution {
    public int hammingDistance(int x, int y) {
        
        int z = x ^ y;
        
        //System.out.println(z);
        int ans = 0;
        
        while(z > 0)
        {
            if(z%2!=0)
                ans++;
            z/=2;
        }
        
        return ans;
    }
}