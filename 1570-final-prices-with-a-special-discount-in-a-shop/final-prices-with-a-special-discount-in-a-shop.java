class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<int[]> st = new Stack<>();
        int length = prices.length;
        int discountedPrice[] = new int[length]; 

        for(int i=0;i<length;i++) {
            while(!st.isEmpty() && st.peek()[0]>=prices[i]) {
                int price = st.peek()[0];
                int idx = st.peek()[1];
                st.pop();
                discountedPrice[idx] = price - prices[i];
            } 
            st.push(new int[]{prices[i],i});
        }

        while(!st.isEmpty()) {
            int price = st.peek()[0];
            int idx = st.peek()[1];
            st.pop();
            discountedPrice[idx] = price;
        }

        return discountedPrice;
    }
}

/*
    8->4
    4->2
    6->2
    2->0
    3->0


    6
    4

*/