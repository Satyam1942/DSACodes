class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int length = arr.length;
        int maxLength = 0;
        for(int i=0; i<length;i++) {
            for(int j=i+1;j<length; j++) {
                int a = arr[i];
                int b = arr[j];
                int lengthOfSeq = 2;
                while(true) {
                    int num = a+b;
                    int left = j+1;
                    int right = length-1;
                    boolean found = false;
                    while(left<=right) {
                        int mid = (left+right)/2;
                        if(arr[mid]>num) {
                            right = mid-1; 
                        } else if(arr[mid]<num) {
                            left = mid+1;
                        } else {
                            found = true;
                            a = b;
                            b = arr[mid];
                            break;
                        }
                    }
                    if(!found) {
                        break;
                    }
                    lengthOfSeq++;
                } 
                maxLength = Math.max(maxLength, lengthOfSeq);
            }
        }
        
        if(maxLength<3) {
            return 0;
        }
        return maxLength;
    }
}
/*
    1 3  
    1 7
    1 11 12
    1 14 
    1 18

*/