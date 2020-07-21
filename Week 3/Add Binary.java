class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int min = Math.min(len1, len2);
        char carry = '0';
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(; i < min; i++)
        {
            char a1 = a.charAt(len1-1);
            char b1 = b.charAt(len2-1);
            len1--;
            len2--;
            if(carry == '0')
            {
                if(a1 == '0')
                {
                    sb.insert(0, b1);
                }
                else if(b1 == '0')
                {
                    sb.insert(0, '1');
                }
                else
                {
                    carry = '1';
                    sb.insert(0, '0');
                }
            }
            else
            {
                if(a1 == '0')
                {
                    if(b1 == '0')
                    {
                        sb.insert(0, '1');
                        carry = '0';
                    }
                    else
                    {
                        sb.insert(0, '0');
                    }
                }
                else if(b1 == '0')
                {
                    sb.insert(0, '0');
                }
                else
                {
                    carry = '1';
                    sb.insert(0, '1');
                }
            }
        }
        while(carry == '1' && len1!=len2)
        {
            if(len1 > len2)
            {
                char a1 = a.charAt(len1-1);
                len1--;
                if(a1 == '0')
                {
                    carry = '0';
                    sb.insert(0, '1');
                }
                else
                    sb.insert(0, '0');
            }
            else
            {
                char b1 = b.charAt(len2-1);
                len2--;
                if(b1 == '0')
                {
                    carry = '0';
                    sb.insert(0, '1');
                }
                else
                    sb.insert(0, '0');
            }
        }
        if(carry == '1')
            sb.insert(0, '1');
        while(len1!=len2)
        {
            if(len1 > len2)
            {
                char a1 = a.charAt(len1-1);
                len1--;
                sb.insert(0, a1);
            }
            else
            {
                char b1 = b.charAt(len2-1);
                len2--;
                sb.insert(0, b1);
            }
        }
        return sb.toString();
    }
}