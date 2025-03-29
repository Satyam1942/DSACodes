class Solution {
    int calculateScore(int num) {
        int score = 0;
        for(int i = 2; i*i<=num; i++) {
            boolean flag = false;
            while(num%i==0) {
                flag = true;
                num/=i;
            }
            if(flag) {
                score++;
            }
        }

        if(num>1) {
            score++;
        }

        return score;
    }

    void computeRepeatLimit(List<Integer> nums, int score[], PriorityQueue<long[]> scoreMap) {
        Stack<Integer> st = new Stack<>();
        int length = nums.size();
        for(int i=0; i<length; i++) {
            while(!st.isEmpty() && score[st.peek()]<score[i]) {
                int index = st.peek();
                int val = nums.get(index);
                st.pop();
                int leftLimit = i-index;
                int rightLimit = (st.isEmpty())? index+1: index-st.peek();
                scoreMap.add(new long[]{val, (long)leftLimit*(long)rightLimit});
            }
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            int index = st.peek();
            int val = nums.get(index);
            st.pop();
            int leftLimit = length - index;
            int rightLimit = (st.isEmpty())? index+1: index-st.peek();
            scoreMap.add(new long[]{val, (long)leftLimit*(long)rightLimit});
        }
    }

    long calcPow(long x, long power) {
        long ans = 1l;
        long mod = (long)(1e9+7);
        for (int i = 0; i < 31; i++) {
            if ((power & (1 << i)) > 0) {
                ans =  (ans*x)%mod;
            }
            x = (x*x)%mod;
        }
        return ans;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int length = nums.size();
        int score [] = new int[length];
        PriorityQueue<long[]> scoreMap = new PriorityQueue<>((a,b)->(Long.compare(b[0],a[0])));
        
        for(int i=0; i<length; i++) {
            score[i] = calculateScore(nums.get(i));
        }

        computeRepeatLimit(nums, score, scoreMap);

        long product = 1l;
        long mod = (long)(1e9+7);
        while(k>0) {
            long num = scoreMap.peek()[0];
            long limit = scoreMap.peek()[1];
            scoreMap.poll();

            long pow = calcPow(num, Math.min(limit,(long)k));
            product = (product*pow)%mod;
            k-=limit;
        }

        return (int)product;
    }   
}

/*
    score = 1
        19  12  14  6   10  18
    x   1   2   2   2   2   2   x

    19 = 1
    18 = 1
    14 = 4
    12 = 6
    10 = 2
    6  = 3
    for constructing this find next greater and subtract from curIndex
    and sort the list in terms of value from largest to smalles

    a particular number can be part of array :
    1. a = pos of a number whose score is more ahead - curPos+1
    2. num^(min(k,a)) ;

    19*18*14
*/