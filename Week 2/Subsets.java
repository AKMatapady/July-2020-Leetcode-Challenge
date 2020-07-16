class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int n = nums.length;
        ans.add(new ArrayList<Integer>());
        for(int i = 1; i < Math.pow(2, n); i++)
        {
            List<Integer> sub = new ArrayList();
            for(int j = 0; j < n; j++)
            {
                if((i & (1 << j)) > 0)
                    sub.add(nums[j]);
            }
            ans.add(sub);
        }
        //System.out.println(ans);
        
        return ans;
    }
}