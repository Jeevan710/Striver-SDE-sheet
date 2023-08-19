public class Solution {
    class Queue {
        int front, rear;
        int []arr;
        int curSize;
        int capacity;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
            curSize=0;
            capacity=100001;
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            if(curSize!=capacity)
            {
                arr[rear++]=e;
                curSize++;
                if(rear==capacity)
                {
                    rear=0;
                }
            }
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if(curSize==0)
            {
                return -1;
            }
            else
            {
                curSize--;
                int res=arr[front];
                front++;
                if(front==capacity)
                {
                    front=0;
                }
                return res;
            }
        }
    }
}