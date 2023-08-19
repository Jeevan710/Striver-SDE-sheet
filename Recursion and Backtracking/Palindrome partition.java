class Solution {
    public Boolean isPalindrome(String s,int start,int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void partition(String s,List<List<String>> res,List<String> r,int n,int i)
    {
        if(i==n)
        {
            res.add(new ArrayList<>(r));
            return;
        }
        for(int ind=i;ind<n;ind++)
        {
            if(isPalindrome(s,i,ind))
            {
                r.add(s.substring(i,ind+1));
                partition(s,res,r,n,ind+1);
                r.remove(r.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> r=new ArrayList<>();
        partition(s,res,r,s.length(),0);
        return res;
    }
}