class StockPrice {

    int maxTime;
    HashMap<Integer,Integer> priceTable; // time , price
    TreeMap<Integer,HashSet<Integer>> orderedPriceMap;  //stockPrice, Set of times

    public StockPrice() {
        priceTable = new HashMap<>();
        orderedPriceMap = new TreeMap<>();   
        maxTime = 0; 
    }
    
    public void update(int timestamp, int price) {
        maxTime = Math.max(maxTime,timestamp);
        
        if(priceTable.containsKey(timestamp)){
            int oldPrice = priceTable.get(timestamp);
            if(orderedPriceMap.get(oldPrice).size()==1)
                orderedPriceMap.remove(oldPrice);
            else
                orderedPriceMap.get(oldPrice).remove(timestamp);
        }

        if(!orderedPriceMap.containsKey(price))
            orderedPriceMap.put(price,new HashSet<>());
        orderedPriceMap.get(price).add(timestamp);

        priceTable.put(timestamp,price);
    }
    
    public int current() {
        return priceTable.get(maxTime);
    }
    
    public int maximum() {
        return orderedPriceMap.lastKey();
    }
    
    public int minimum() {
        return orderedPriceMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */