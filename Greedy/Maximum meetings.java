import java.util.* ;
import java.io.*; 

class meeting{
    int start;
    int end;
    int pos;
    meeting(int start,int end,int pos)
    {
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}
class meetingComparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting m1,meeting m2)
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
public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        int n=start.length;
        ArrayList<meeting> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            arr.add(new meeting(start[i], end[i], i));
        }
        meetingComparator mC=new meetingComparator();
        Collections.sort(arr, mC);
        List<Integer> res=new ArrayList<>();
        int limit=arr.get(0).end;
        res.add(arr.get(0).pos+1);
        for(int i=1;i<n;i++)
        {
            if(arr.get(i).start>limit)
            {
                limit=arr.get(i).end;
                res.add(arr.get(i).pos+1);
            }
        }
        return res;
    }
}