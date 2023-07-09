//Checking rows and columns binary search

class Solution {
    public int search(int[] matrix,int target,int start,int end)
    {
        if(start<=end)
        {
            int mid=start + (end-start)/2;
            if(matrix[mid]==target)
            {
                return mid;
            }
            if(matrix[mid]>target)
            {
                return search(matrix,target,start,mid-1);
            }
                return search(matrix,target,mid+1,end);
        }
        return -1;
    }
    public int searchRow(int[][] matrix,int target,int start,int end,int m)
    {
        if(start<=end)
        {
        int mid=start+(end-start)/2;
        if(matrix[mid][0]==target)
        {
            return mid;
        }
        if(matrix[mid][0]<target)
        {
            if(matrix[mid][m-1]>=target)
            {
                return mid;
            }
            else
            {
                return searchRow(matrix,target,mid+1,end,m);
            }
        }
        else
        {
            return searchRow(matrix,target,start,mid-1,m);
        }
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        int index=searchRow(matrix,target,0,n-1,m);
        System.out.println(index);
        if(index==-1 || search(matrix[index],target,0,m-1)==-1)
        {
            return false;
        }

        return true;
    }
}



///Considering 2D matrix as linear matrix

class Solution {
    public int search(int[][] matrix,int target,int start,int end,int m)
    {
        if(start<=end)
        {
            int mid=start + (end-start)/2;
            if(matrix[mid/m][mid%m]==target)
            {
                return mid;
            }
            if(matrix[mid/m][mid%m]>target)
            {
                return search(matrix,target,start,mid-1,m);
            }
                return search(matrix,target,mid+1,end,m);
        }
        return -1;
    }
  
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int len=n*m;
        if(search(matrix,target,0,len-1,m)==-1)
        {
            return false;
        }
        return true;
    }
}