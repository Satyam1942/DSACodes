class Solution {
    public int buyChoco(int[] price , int money) {
       Arrays.sort(price);
       int cost = price[0]+price[1];
       int left = money-cost; 

       if(left<0) return money;
       else return left;
    }
}