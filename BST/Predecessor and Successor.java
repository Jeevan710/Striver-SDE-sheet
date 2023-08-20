
// code here.
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */

//Function to check whether a Binary Tree is BST or not.
public static void findPreSuc(Node root, int key)
{
    if(root==null)
    {
        return;
    }
    if(key==root.data)
    {
        Node t=root;
        if(t.left!=null)
        {
            t=t.left;
            while(t.right!=null)
            {
                t=t.right;
            }
            pre=t;
        }
        t=root;
        if(t.right!=null)
        {
            t=t.right;
            while(t.left!=null)
            {
                t=t.left;
            }
            suc=t;
        }
        return;
    }
    if(key<root.data)
    {
        suc=root;
        findPreSuc(root.left,key);
    }
    else
    {
        pre=root;
        findPreSuc(root.right,key);
    }
    
}
}