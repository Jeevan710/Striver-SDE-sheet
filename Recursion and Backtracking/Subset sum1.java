

//User function Template for Java//User function Template for Java
class Solution{
    
    void subsetSum(int n,int s,ArrayList<Integer> arr,ArrayList<Integer> res,int a)
    {
        if(a==n)
        {
            res.add(s);
            return;
        }
        subsetSum(n,s+arr.get(a),arr,res,a+1);
        subsetSum(n,s,arr,res,a+1);
        
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> res=new ArrayList<>();
        subsetSum(N,0,arr,res,0);
        Collections.sort(res);
        return res;
    }
}