class Solution {
    long gcd(long a,long b){
        long ans = Math.min(a,b);
        long num = Math.max(a,b);
        while(ans>0){
            long remainder = num%ans;
            num = ans;
            ans = remainder;
        }

        return num;
    }

    long getLCM(long a,long b){
        return a*b/gcd(a,b);
    }

    boolean isPossible(long mid, long k, List<Long> lcm){
   
        long count = 0;
        for(long i:lcm){
            count+= mid/i;
        }
        return count>=k;
    }

    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        int length = coins.length;

        List<Long> lcm = new ArrayList<>();
        for(int i=1;i<(1<<length);i++){
            long l = 1;
            for(int j=0;j<length;j++){
                if((i&(1<<j)) >0){
                    l = getLCM(l,(long)coins[j]);
                }
            }
            lcm.add(l * (Integer.bitCount(i) % 2 == 1 ? 1 : -1));
        }

        long lowerBound  = coins[0];
        long upperBound =  (long)k*(long)coins[0];
        long ans = upperBound;
        while(lowerBound<=upperBound){
            long mid = lowerBound+(upperBound-lowerBound)/2l;
            if(isPossible(mid,k,lcm)){
                ans = mid;
                upperBound = mid-1;
            }else{
                lowerBound = mid+1;
            }
        }
        return ans;
        
    }
}