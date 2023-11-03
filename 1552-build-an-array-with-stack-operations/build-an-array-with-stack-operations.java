class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> order = new ArrayList<>();
        int curNum = 1;
        for(int i=0;i<target.length;)
        {
            if(target[i]==curNum) {order.add("Push"); i++;}
            else
            {
                order.add("Push");
                order.add("Pop");
            }
             curNum++;
        }
       return order;
    }
}