public class Solution{
    static class Stack {
        int[] stack;
        int end;
        int capacity;
        Stack(int capacity) {
            this.stack=new int[capacity];
            this.end=0;
            this.capacity=capacity;
        }
        public void push(int num) {
            if(end<capacity)
            {
                stack[end++]=num;
            }
        }
        public int pop() {
            if(end>0)
            {
                end--;
                return stack[end];
            }
            else{
                return -1;
            }
        }
        public int top() {
            if(end>0)
            {
                return stack[end-1];
            }
            else
            {
                return -1;
            }
        }
        public int isEmpty() {
            if(end==0)
            {
                return 1;
            }
            else{
                return 0;
            }
        }
        public int isFull() {
            if(end==capacity)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}