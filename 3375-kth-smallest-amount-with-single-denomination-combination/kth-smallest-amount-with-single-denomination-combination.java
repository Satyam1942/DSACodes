class Solution {
    boolean isPossible(long val, int k, List<Long> lcmList ){
        long rank = 0;
        for(long lcm: lcmList){
            rank+= val/lcm;
        }
        return rank>=k;
    }
    
    long getGcd(long a, long b){
        long gcd = Math.min(a,b);
        long temp = Math.max(a,b);
        b = temp;
        a = gcd;
        while(b%a>0){
            long r = b%a;
            b = a;
            a = r;
            gcd = a;
        }
        return gcd;
    }

    long getLcm(long a, long b){
        return (a*b)/getGcd(a,b);
    }

    void getLcmList(int length, int coins[], List<Long> lcmList){
        
        for(int i=1;i<(1<<length);i++){
            long lcm = 0;
            int count = 0;
            for(int bit = 0; bit<31;bit++){
                if((i&(1<<bit))>0){
                    count++;
                    if(lcm==0)
                        lcm = (long)coins[bit];
                    else
                        lcm = getLcm(lcm,(long)coins[bit]);
                }
            }
            lcmList.add(lcm*((count%2==0)?-1:1));
        }
    }

    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        List<Long> lcmList = new ArrayList<>();
        int length = coins.length;
        getLcmList(length,coins,lcmList);

        long left = coins[0];
        long right = (long)coins[0]*(long)k;
        long val = right;

        while(left<=right){
            long mid = left+(right-left)/2;
            if(isPossible(mid,k,lcmList)){
                right = mid-1;
                val = mid;
            }else
                left = mid+1;
        }

        return val;
    }
}

/*
    3=> 3,6,9
    6=> 6,12
    9=> 9,18

    min = 2
    max = 14
    coins = 2,5
    find lcm of numbers with which it is divisible
    2,5,10
 */