class Solution {
   List<Integer> sieve(int n) {
        boolean isPrime[] = new boolean[n+1];
        List<Integer> primeNos = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for(int i=2;i*i<=n;i++) {
            if(isPrime[i]) {
                for(int j = i*i; j<=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(isPrime[i]) {
                primeNos.add(i);
            }
        }

        return primeNos;
    }

    int calcStartIndex (int num, List<Integer> prime) {
        int left = 0;
        int right = prime.size()-1;
        int startIndex = right;

        while(left<=right) {
            int mid = (left+right)/2;
            if(prime.get(mid)>=num) {
                startIndex = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return startIndex;
    }
    
    public int[] closestPrimes(int left, int right) {
        List<Integer> prime = sieve(right);
        int startIndex = calcStartIndex(left, prime);
        int i = startIndex;
        int minDif = Integer.MAX_VALUE;
        int x = -1;
        int y = -1;
        while(i+1<prime.size() && prime.get(i+1)<=right) {
            if(prime.get(i+1)-prime.get(i)<minDif) {
                minDif = prime.get(i+1)-prime.get(i);
                x = prime.get(i);
                y = prime.get(i+1);
            }
            i++;
        }
        return new int[] {x,y};
    }
}


/*
    
*/