class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> remainderMap = new HashMap<>();
        int length = arr.length;
        int noOfPairs = 0;

        for(int i=0;i<length;i++) {
            int curNum = arr[i];
            int remainder = (arr[i]>=0 || arr[i]%k==0) ? arr[i]%k:arr[i]%k+k;
            
            if(remainderMap.containsKey(remainder)) {
                int freq = remainderMap.get(remainder);
                if(freq==1) {
                    remainderMap.remove(remainder);
                } else {
                    remainderMap.put(remainder,freq-1);
                }
                noOfPairs++;
            } else {
                if(remainder == 0) {
                    remainderMap.put(remainder,1);
                } else {
                    int freq = remainderMap.getOrDefault(k-remainder,0);
                    remainderMap.put(k-remainder,freq+1);
                }
            }
        }

        return noOfPairs == length/2;
    }
}

/*

    -4 => 2
    -7 => 2
     5 => 2  
     2 => 2
     9 => 0
     1 => 1
    10 => 1
     4 => 1
    -8 => 1
    -3 => 0 

 */