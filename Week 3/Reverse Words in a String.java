class Solution {
    public String reverseWords(String s) {
        
        String[] str = s.trim().split("\\s+");
        if(str.length < 1)
            return "";
        int len = str.length;
        StringBuilder sb = new StringBuilder();
        sb.append(str[len-1]);
        for(int i = len-2; i >=0; i--)
        {
            sb.append(" ");
            sb.append(str[i]);
        }
        return sb.toString();
    }
}