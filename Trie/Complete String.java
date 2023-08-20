import java.util.* ;
import java.io.*; 

class Node 
{
  Node[] arr=new Node[26];
  boolean flag=false; 
}
class Solution {
  static Node root=new Node();
  private static void insert(String word)
  {
    Node temp=root;
    for(char c:word.toCharArray())
    {
      int ind=c-'a';
      if(temp.arr[ind]==null)
      {
        temp.arr[ind]=new Node();
      }
      temp=temp.arr[ind];
    }
    temp.flag=true;
  }
  private static boolean search(String word)
  {
    Node temp=root;
    for(char c:word.toCharArray())
    {
      int ind=c-'a';
      temp=temp.arr[ind];
      if(temp.flag==false)
      {
        return false;
      }
    }
    return true;
  }
  public static String completeString(int n, String[] a) {
      String res="";
      root=new Node();
      for(int i=0;i<n;i++)
      {
        insert(a[i]);
      }
      for(String word:a)
      {
        if(!search(word))
        {
          continue;
        }
        if(word.length()>res.length())
        {
            res=word;
        }
        else if(word.length()==res.length() && res.compareTo(word)>0)
        {
          res=word;
        }
      }
      if(res.length()==0)
      {
        return "None";
      }
      return res;
  }
}