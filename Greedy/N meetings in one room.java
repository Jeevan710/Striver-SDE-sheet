
class meet{
    int start;
    int end;
    int pos;
    meet(int start,int end,int pos)
    {
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}
class comp implements Comparator<meet>
{
    @Override
    public int compare(meet m1,meet m2)
    {
        if(m1.end<m2.end)
        {
            return -1;
        }
        else if(m1.end>m2.end)
        {
            return 1;
        }
        else if(m1.pos<m2.pos)
        {
            return -1;
        }
        return 1;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<meet> m=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            meet mm=new meet(start[i],end[i],i);
            m.add(mm);
        }
        comp cp=new comp();
        Collections.sort(m,cp);
        
        int res=1;
        int limit=m.get(0).end;
        for(int i=1;i<n;i++)
        {
            if(m.get(i).start>limit)
            {
                limit=m.get(i).end;
                res++;
            }
        }
        return res;
    }
}