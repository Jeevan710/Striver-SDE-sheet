class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<m;i++)
        {

                while(s.isEmpty()==false && nums2[s.peek()]<nums2[i])
                {
                    map.put(nums2[s.peek()],nums2[i]);
                    s.pop();
                }
                s.push(i);
        }

            while(s.isEmpty()==false)
            {
                map.put(nums2[s.peek()],-1);
                s.pop();
            }
            int res[]=new int[n];
            for(int i=0;i<n;i++)
            {
               // if(map.containsKey(num))
                res[i]=map.get(nums1[i]);
            }
            return res;
        
    }
}