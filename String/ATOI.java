class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int n=s.length();
        int res=0;
        boolean flag=true;
        int i=0;
        if(n==0)
        {
            return 0;
        }
         if(s.charAt(i)=='+')
         {
             i++;
         }
            else if(s.charAt(i)=='-')
            {
                i++;
                flag=false;
            }
        for(;i<n;i++)
        {
            if(!Character.isDigit(s.charAt(i)))
            {
                break;
            }
            int digit=Character.getNumericValue(s.charAt(i));
            if(res>(Integer.MAX_VALUE-digit)/10)
            {
                return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            else
            {
                res=res*10+digit;
            }
        }
        if(flag==false)
        {
            res=-res;
        }
        return res;
    }
}