class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int sell=0;
        int maxSell=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            buy=Math.min(buy,prices[i]);
            sell=prices[i]-buy;
            maxSell=Math.max(maxSell,sell);
        }
        return maxSell;
    }
}