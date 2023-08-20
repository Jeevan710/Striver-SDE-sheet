class KthLargest {
    PriorityQueue<Integer> min=new PriorityQueue<>();
    int cap;
    public KthLargest(int k, int[] nums) {
        cap=k;
        for(int i=0;i<nums.length;i++)
        {
            min.add(nums[i]);
            if(min.size()>cap)
            {
                min.remove();
            }
        }
    }
    
    public int add(int val) {
        min.add(val);
        if(min.size()>cap)
        {
            min.remove();
        }
        return min.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */