class Solution {
    public String countAndSay(int n) {
        if(n==1)
        {
            return "1";
        }
        String temp=countAndSay(n-1)+"$";
        StringBuilder s=new StringBuilder("");
        int freq=1;
        char a=temp.charAt(0);
        for(int i=1;i<temp.length();i++)
        {
            if(temp.charAt(i)==a)
            {
                freq++;
            }
            else
            {
                s.append((char)(freq+'0'));
                s.append(String.valueOf(a));
                freq=1;
                a=temp.charAt(i);
            }
        }
        return s.toString();
    }
}