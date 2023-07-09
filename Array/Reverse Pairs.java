class Solution {
    public static void merge(int[] nums,int start,int mid,int end)
    {
        ArrayList<Integer> temp=new ArrayList<>();
        int i=start,j=mid+1;
        while(i<=mid && j<=end)
        {
            if(nums[i]<=nums[j])
            {
                temp.add(nums[i]);
                i++;
            }
            else
            {
                temp.add(nums[j]);
                j++;
            }
        }
        while(i<=mid)
        {
            temp.add(nums[i]);
            i++;
        }
        while(j<=end)
        {
            temp.add(nums[j]);
            j++;
        }
        for(i=start;i<=end;i++)
        {
            nums[i]=temp.get(i-start);
        }
    }

    public static int countPairs(int[] nums,int start,int mid,int end)
    {
        int j=mid+1;
        int count=0;
        for(int k=start;k<=mid;k++)
        {
            while(j<=end && nums[k]>(2*(long)nums[j]))
            {
                j++;
            }
            count+=(j-(mid+1));
        }
        return count;
    }

    public static int mergeSort(int[] nums,int start,int end)
    {
        if(start>=end)
        {
            return 0;
        }
        int count=0;
        int mid=start+(end-start)/2;
        count+=mergeSort(nums,start,mid);
        count+=mergeSort(nums,mid+1,end);
        count+=countPairs(nums,start,mid,end);
        merge(nums,start,mid,end);
        return count;
    }

    public int reversePairs(int[] nums) {
        int res=mergeSort(nums,0,nums.length-1);
        return res;
    }
}