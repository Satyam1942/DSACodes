class Solution {
    public long putMarbles(int[] weights, int k) {
        List<Long> boundary = new ArrayList<>();
        int length = weights.length;
        for(int i=1;i<length;i++) {
            long cur = weights[i];
            long prev = weights[i-1];
            long boundarySum = cur+prev;
            boundary.add(boundarySum);
        }

        Collections.sort(boundary);
        long maxSum = 0;
        long minSum = 0;
        for(int i=0;i<k-1; i++) {
            minSum+=boundary.get(i);
        }

        
        for(int i=boundary.size()-1;i>boundary.size()-k; i--) {
            maxSum+=boundary.get(i);
        }

        return maxSum-minSum;
    }
}

/*
    1,  3,  5,  1

    max = 20
    min = 0
    
    we need to find max difference
    1,  3,  5,  1,  2, 7, 9, 1
      4   8   6   3   9  16 10
b = 10

  16,10,9 = 35
  3,4,6 = 13
    22

    k=4  
    maxSize = 5
    minSize = 1

    x1-----------------x2 ;x3 ----------x4
    x1----------x5;x6 --------------------x4
    
    x5-x2 + x6-x3

    1,3
    3,5


    1,3  ;  5, 
    1,5 

    no of partitions = k-1

*/