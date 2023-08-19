class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        int i=0;
        while(i<n)
        {
            if(s.charAt(i)=='{' ||s.charAt(i)=='(' || s.charAt(i)=='[')
            {
                st.push(s.charAt(i));
            }
            else
            {
                if((!st.empty()) && ((s.charAt(i)=='}' && st.peek()=='{' )||(s.charAt(i)==']' && st.peek()=='[' )||(s.charAt(i)==')' && st.peek()=='(' )))
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }
            i++;
        }
        if(!st.empty())
        {
            return false;
        }
        return true;
    }
}