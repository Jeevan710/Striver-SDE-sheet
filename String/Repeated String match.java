class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n=b.length()/a.length();
        StringBuilder s=new StringBuilder();
        for(int i=0;i<n+3;i++)
        {
            if(s.toString().contains(b))
            {
                return i;
            }
            else
            {
                s.append(a);
            }
        }
        return -1;
    }
}