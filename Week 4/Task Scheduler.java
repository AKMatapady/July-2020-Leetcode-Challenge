class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0)
            return tasks.length;
        //Character -> frequency
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        int max = 0;
        for(char x: tasks)
        {
            int curr = mp.getOrDefault(x, 0)+1;
            mp.put(x, curr);
            if(curr > max)
                max = curr;
        }
        int num = 0;
        for(char x: mp.keySet())
        {
            if(mp.get(x) == max)
                num++;
        }
        
        return Math.max(tasks.length, ((max-1)*(n+1))+num);
    }
}