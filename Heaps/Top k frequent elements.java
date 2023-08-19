class Pair{
    int key;
    int value;
    Pair(int key,int value)
    {
        this.key=key;
        this.value=value;
    }
}
class PairComp implements Comparator<Pair>
{
    @Override
    public int compare(Pair a,Pair b)
    {
        return b.value-a.value;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(m.containsKey(nums[i]))
            {
                m.put(nums[i],m.get(nums[i])+1);
            }
            else
            {
                m.put(nums[i],1);
            }
        }
        int i=0;
        int[] res=new int[k];
        PriorityQueue<Pair> pq=new PriorityQueue<>(new PairComp());
        for(Map.Entry<Integer,Integer> entry:m.entrySet())
        {
            int a=entry.getKey();
            int v=entry.getValue();
            pq.add(new Pair(a,v));
        }
        while(pq.isEmpty()==false && k--!=0)
        {
            res[i++]=pq.peek().key;
            pq.remove();
        }
        return res;
    }
}