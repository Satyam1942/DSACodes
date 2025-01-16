class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int xor1 = 0;
        int xor2 = 0;

        for(int i=0;i<length1;i++) {
            xor1^=nums1[i];
        }
        
        for(int i=0;i<length2;i++) {
            xor2^=nums2[i];
        }
        
        if(length1%2==0 && length2%2==0) {
            return 0;
        } else if(length1%2==0) {
            return xor1;
        } else if(length2%2==0) {
            return xor2;
        } else {
            return xor1^xor2;
        }
    }
}


/*
    2,1,3
    10,2,5,0
    2^10, 2^2, 2^5,, 1^10,  1^2, 1^5, 3^10, 3^2, 3^5,
    10^2^5^0 

    if both even => return 0
    if arr1 even => return xor of arr1
    if arr2 even => return xor of arr2 
    else xor1 ^ xor2
*/