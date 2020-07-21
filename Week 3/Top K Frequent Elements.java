class Solution {
    
    class Temp
    {
        int val;
        int count;
        Temp(int a, int b)
        {
            val = a;
            count = b;
        }
        @Override
        public String toString()
        {
            return val + ": " + count;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        if(k >= nums.length)
            return nums;
        HashMap<Integer, Integer> mp = new HashMap();
        Set<Integer> st = new HashSet();
        
        int len = nums.length;
        
        for(int i = 0; i < len; i++)
        {
            st.add(nums[i]);
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        
        if(k >= st.size())
        {
            int[] ans = new int[st.size()];
            int i = 0;
            for(int x: st)
            {
                ans[i] = x;
                i++;
            }
            return ans;
        }
        PriorityQueue<Temp> pq = new PriorityQueue(new Comparator<Temp>(){
           @Override
            public int compare(Temp a, Temp b)
            {
                return a.count - b.count;
            }
        });
        for(int x: st)
        {
            Temp t = new Temp(x, mp.getOrDefault(x,0));
            //System.out.println("tezst : " + t.toString());
            if(pq.size() < k)
                pq.add(t);
            else
            {
                Temp t2 = pq.peek();
                if(t2.count < t.count)
                {
                    pq.poll();
                    pq.add(t);
                    //System.out.println(t.val + ": " + t.count + "; " + t2.val + ": " + t2.count);
                }
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty() && i < k)
        {
            Temp t = pq.poll();
            ans[i] = t.val;
            i++;
        }
        return ans;
    }
}