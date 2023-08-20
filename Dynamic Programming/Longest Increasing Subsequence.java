class Solution {
    public int lengthOfLIS(int[] nums) {
      int n=nums.length;
      List<Integer> l=new ArrayList<>();
      l.add(nums[0]);

      for(int i=1;i<n;i++)
      {
          if(nums[i]>l.get(l.size()-1))
          {
              l.add(nums[i]);
          }
          else
          {
              int low=0;
              int high=l.size()-1;
              while(low<=high)
              {
                  int mid=(high+low)/2;
                  if(l.get(mid)<nums[i])
                  {
                      low=mid+1;
                  }
                  else
                  {
                      high=mid-1;
                  }
              }
              l.set(low,nums[i]);
          }
      }
      return l.size();
    }
}