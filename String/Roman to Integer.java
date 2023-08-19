class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int n=s.length();
        int res=0;
        char a;
        for(int i=0;i<n-1;i++)
        {
            a=s.charAt(i);
            if(map.get(a)<map.get(s.charAt(i+1)))
            {
                res-=map.get(a);
            }
            else
            {
                res+=map.get(a);
            }
        }
        res+=map.get(s.charAt(n-1));
        return res;
    }
}