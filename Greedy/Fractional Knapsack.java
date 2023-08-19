

/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class comp implements Comparator<Item>
{
    @Override
    public int compare(Item a,Item b)
    {
        double r1=(double)a.value/(double)a.weight;
        double r2=(double)b.value/(double)b.weight;
        if(r2>r1)
        {
            return 1;
        }
        else if(r1>r2)
        {
            return -1;
        }
        return 0;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        comp cp=new comp();
        Arrays.sort(arr,cp);
        int i=0;
        int curW=0;
        double profit=0.0;
        while(i<n)
        {
            if(curW+arr[i].weight>W)
            {
                int remain=W-curW;
                profit+=(double)((double)arr[i].value/(double)arr[i].weight)*(double)remain;
                break;
            }
            else
            {
                curW+=arr[i].weight;
                profit+=(double)arr[i].value;
            }
            i++;
        }
        return profit;
    }
}