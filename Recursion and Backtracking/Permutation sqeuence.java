class Solution {

    public String getPermutation(int n, int k) {
        int per=1;
        int m=n;
        ArrayList<Integer> num=new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            num.add(i);
            per*=i;
        }
        num.add(n);
        int a=per;
        String s="";
        k=k-1;
        while(true)
        {
            s=s+""+num.get(k/a);
            num.remove(k/a);
            if(num.size()==0)
            {
                break;
            }
            k=k%a;
            a=a/num.size();
        }
        return s;
    }
}