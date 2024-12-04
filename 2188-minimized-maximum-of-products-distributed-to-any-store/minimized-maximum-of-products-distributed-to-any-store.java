class Solution {
    long sumOfQuantities(int quantities[]) {
        int length = quantities.length;
        long sum = 0;
        for(int i=0;i<length;i++) {
            sum+=quantities[i];
        }
        return sum;
    }   

    boolean isPossible(int quantities[], int n, long maxAmount) {
        int length = quantities.length;
      
        for(int index = 0; index<length;index++) {
            int curAmount = quantities[index];
            int numberOfShops = (int)Math.ceil(curAmount/(double)maxAmount);
            n-=numberOfShops;
        }
        return n>=0;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        long left = 1;
        long right = sumOfQuantities(quantities);

        long maxProducts = right;
        while(left<=right) {
            long mid = (left+right)/2;
            if(isPossible(quantities,n,mid)) {
                right = mid-1;
                maxProducts = mid;
            } else {
                left = mid+1;
            }
        }

        return (int)maxProducts;
    }
}