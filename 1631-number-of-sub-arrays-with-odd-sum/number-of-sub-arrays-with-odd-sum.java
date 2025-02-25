class Solution {
    public int numOfSubarrays(int[] arr) {
        int length = arr.length;
        long mod = (long)(1e9+7);
        int oddIndex = 0;
        int ans[] = new int[length];
        List<Integer> oddIndices = new ArrayList<>();
        
        for(int i=0; i<length;i++) {
            int num = arr[i];
            if(num%2!=0) {
                if(oddIndex == 0) {
                    ans[i] = i+1;
                } else if(oddIndex==1) {
                    ans[i] = i-oddIndices.get(oddIndex-1);
                } else {
                    ans[i] = ans[oddIndices.get(oddIndex-2)] + i-oddIndices.get(oddIndex-1);
                }
                oddIndices.add(i);
                oddIndex++;
            } else {
                ans[i] = (i==0)?0:ans[i-1];
            }
        }

        long numberOfSubarrays = 0;
        for(int i=0; i<length;i++) {
            numberOfSubarrays = (numberOfSubarrays + (long)ans[i])%mod;
        }
        return (int)numberOfSubarrays;
    }
}

/*
    1 3 5
    1 1 2

    1 2 3 4 5 6 7
    1 1 2 2 3 3 4

    2 1 3
    0 2 1

    1-0
    3-2
    5-4
    7-6
    for any even no ans = ans[index-1];
    for any odd no ans = ans[lastToLastOddIndex] + curIndex-lastOddIndex;

*/