class Solution {
    
    List<List<Integer>> res;
    
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList();
        if(nums == null || nums.length < 1)
            return res;
        Arrays.sort(nums);
        // if(nums[0] > 0)
        //     return res;
        int len = nums.length;
        
        for(int i = 0; i < len; i++)
        {
            if(nums[i]> 0)
                break;
            if(i > 0 && nums[i]==nums[i-1])
                continue;
            int j = i+1, k = len-1;
            while(j < k)
            {
                if((nums[i]+nums[j]+nums[k])==0)
                {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1])
                        j++;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                }
                else if((nums[i]+nums[j]+nums[k])>0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        return res;
    }
}