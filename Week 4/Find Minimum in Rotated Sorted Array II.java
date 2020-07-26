class Solution {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length-1])
            return nums[0];
        //int ref = nums[0];
        int start = 0, end = nums.length-1;
        while(start <= end)
        {
            //System.out.println("start: " + start + ", end: " + end);
            while(nums[start] == nums[end] && start!=end) 
                start++;
            if(nums[start]<=nums[end])
                return nums[start];
            int mid = start + (end-start)/2;
            //System.out.println("start: " + start + ", end: " + end + ", mid: " + mid);
            if(mid > 0 && nums[mid] < nums[mid-1])
                return nums[mid];
            if(nums[mid] >= nums[start])
                start = mid+1;
            else
                end = mid;
        }
        return nums[start];
    }
}