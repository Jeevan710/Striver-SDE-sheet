class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int n=heights.length;
        int maxa=0;
        int res=0;
        int i=0;
        for(i=0;i<n;)
        {
            if(s.isEmpty() || heights[s.peek()]<=heights[i])
            {
                s.push(i++);
            }
            else
            {
                int a=heights[s.peek()];
                s.pop();
                if(s.isEmpty())
                {
                    maxa=a*i;
                }
                else
                {
                    maxa=a*(i-s.peek()-1);
                }
                res=Math.max(maxa,res);
            }
        }
        while(s.isEmpty()==false)
        {
            int a=heights[s.peek()];
                s.pop();
                if(s.isEmpty())
                {
                    maxa=a*i;
                }
                else
                {
                    maxa=a*(i-s.peek()-1);
                }
                res=Math.max(maxa,res);
        }
        return res;
    }
}