class Solution {
    public boolean isAnagram(String s, String t) {
        char temp[]=s.toCharArray();
        Arrays.sort(temp);
        s=new String(temp);

        char a[]=t.toCharArray();
        Arrays.sort(a);
        t=new String(a);

        if(s.equals(t))
        {
            return true;
        }
        return false;
    }
}