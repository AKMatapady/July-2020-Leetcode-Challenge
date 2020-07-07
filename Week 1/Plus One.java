class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1] < 9)
        {
            digits[digits.length-1] = digits[digits.length-1]+1;
            return digits;
        }
        
        //int[] ans = new int[digits.length+1];
        int i = digits.length-1;
        for(; i>=0; i--)
        {
            if(digits[i] < 9)
            {
                digits[i] = digits[i]+1;
                break;
            }
            else
            {
                digits[i] = 0;
            }
        }        
        if(i>=0)
            return digits;
        int[] ans = new int[digits.length+1];        
        ans[0]=1;
        for(int j = 0; j < digits.length; j++)
        {
            ans[j+1] = digits[j];
        }
        return ans;
    }
}