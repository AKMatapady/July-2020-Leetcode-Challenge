class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        if(nums == null || nums.length < 1)
            return ans;
        if(nums.length == 1)
        {
            ans[0] = nums[0];
            return nums;
        }
        if(nums.length == 2)
        {
            ans[0] = nums[0];
            ans[1] = nums[1];
            return nums;
        }
        Map<Integer, Integer> mp = new HashMap();
        for(int i = 0; i < nums.length; i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        boolean found = false;
        for(int key: mp.keySet())
        {
            if(mp.get(key) == 1)
            {
                if(found)
                {
                    ans[1] = key;
                    return ans;
                }
                found = true;
                ans[0] = key;
            }
        }
        return ans;
    }
}