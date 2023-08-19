class Disjoint
{
    int parent[];
    Disjoint(int n){
        parent=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
    }
    
    int find(int s)
    {
        if(s==parent[s])
        {
            return s;
        }
        return find(parent[s]);
    }
    void merge(int u,int v)
    {
        parent[v]=u;
    }
}
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)-> (b.profit-a.profit));
        
        int m=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i].deadline>m)
            {
                m=arr[i].deadline;
            }
        }
        
        Disjoint d=new Disjoint(m+1);
        int count=0;int profit=0;
        for(int i=0;i<n;i++)
        {
            int available=d.find(arr[i].deadline);
            if(available>0)
            {
                d.merge((d.find(available-1)),available);
                count++;
                profit+=arr[i].profit;
            }
        }
        int[] res=new int[2];
        res[0]=count;
        res[1]=profit;
        return res;
        
    }
}
