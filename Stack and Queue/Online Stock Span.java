class Stock
{
    int price;
    int count;
    Stock(int price,int count)
    {
        this.price=price;
        this.count=count;
    }
}
class StockSpanner {
    Stack<Stock> s;
    public StockSpanner() {
        s=new Stack<>();
    }
    
    public int next(int price) {
        int count=1;
        while(s.isEmpty()==false && price>=s.peek().price)
        {
            count+=s.peek().count;
            s.pop();
        }
        s.push(new Stock(price,count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */