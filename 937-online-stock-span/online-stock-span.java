class Pair
{
    int price;
    int val;
    Pair(int price, int val)
    {
        this.price = price;
        this.val = val;
    }
}

class StockSpanner {
    Stack<Pair> priceStore;
    public StockSpanner() {
        priceStore = new Stack<>();
    }
    
    public int next(int price) {
        int val=0;
       while(!priceStore.isEmpty() && priceStore.peek().price<=price)
        {
            val+=priceStore.pop().val; 
        }
        priceStore.push(new Pair(price,val+1));
        return val+1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */