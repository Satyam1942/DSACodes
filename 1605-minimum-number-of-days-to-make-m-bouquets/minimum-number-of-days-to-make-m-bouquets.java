class Solution {
    int getMin(int bloomDay[]){
        int length = bloomDay.length;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<length;i++)
            mini= Math.min(mini,bloomDay[i]);
        return mini;
    }

    int getMax(int bloomDay[]){
        int length = bloomDay.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<length;i++)
            maxi= Math.max(maxi,bloomDay[i]);
        return maxi;
    }

    boolean isPossible(int days, int m, int k, int bloomDay[]){
        int length = bloomDay.length;
        int bouquetCount = 0;
        int ogK = k;
        for(int i=0;i<length;i++){
            if(bloomDay[i]<=days){
                k--;
            }else{
                k=ogK;
            }
            if(k==0){
                k=ogK;
                bouquetCount++;
            }
        }

        return bouquetCount>=m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int length = bloomDay.length;
        if(length<(long)m*(long)k)
            return -1;

        int left = getMin(bloomDay);
        int right = getMax(bloomDay);
        int minDaysToMakeBouquet = right;
        while(left<=right){
            int mid = (left+right)/2;
            if(isPossible(mid,m,k,bloomDay)){
                right = mid-1;
                minDaysToMakeBouquet =  mid;
            }else{
                left = mid+1;
            }
        }

        return  minDaysToMakeBouquet;
    }
}

/*
    1,10,3,10,2

    1,0
    2,4
    3,2
    10,1
    10,3
    partition the array into m parts each of size >=k

    1 , 10 , 
    9
*/