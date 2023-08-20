import java.util.* ;
import java.io.*; 

class Node
{
    Node arr[]=new Node[26];
    int count=0;
    int prefix=0;
}
public class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }

    public void insert(String word) {
        Node temp=root;
        for(char c:word.toCharArray())
        {
            int ind=c-'a';
            if(temp.arr[ind]==null)
            {
                temp.arr[ind]=new Node();
            }
            temp=temp.arr[ind];
            temp.prefix++;
        }
        temp.count++;
    }

    public int countWordsEqualTo(String word) {
        Node temp=root;
        for(char c:word.toCharArray())
        {
            int ind=c-'a';
            if(temp.arr[ind]==null)
            {
                return 0;
            }
            temp=temp.arr[ind];
        }
        return temp.count;
    }

    public int countWordsStartingWith(String word) {
        Node temp=root;
        for(char c:word.toCharArray())
        {
            int ind=c-'a';
            if(temp.arr[ind]==null)
            {
                return 0;
            }
            temp=temp.arr[ind];
        }
        return temp.prefix;
    }

    public void erase(String word) {
        Node temp=root;
        Node toBeDeleted=null;
        for(char c:word.toCharArray())
        {
            int ind=c-'a';
            Node par=temp;
            temp=temp.arr[ind];
            temp.prefix--;

            if(temp.prefix==0)
            {
                par.arr[ind]=null;
 
            }
        }
        temp.count--;
    }

}
