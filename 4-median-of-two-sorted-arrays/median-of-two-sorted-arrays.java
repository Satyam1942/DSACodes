class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n)
            return findMedianSortedArrays(nums2,nums1);
        int left = 0 ;
        int right = m;
        int totalElementsInGroup = (m+n+1)/2;
        boolean isEven = (m+n)%2==0;
        
        while(left<=right){
            int cut1 = (left+right)/2;
            int cut2 =  totalElementsInGroup-cut1;

            int array1LeftElement  =  (cut1!=0)?nums1[cut1-1]:Integer.MIN_VALUE;
            int array1RightElement = (cut1!=m)?nums1[cut1]:Integer.MAX_VALUE;
            int array2LeftElement  =  (cut2!=0)?nums2[cut2-1]:Integer.MIN_VALUE;
            int array2RightElement = (cut2!=n)?nums2[cut2]:Integer.MAX_VALUE;
          
            if(array1LeftElement>array2RightElement)
                right = cut1-1;
            else if(array2LeftElement>array1RightElement)
                left = cut1+1;
            else{
                if(isEven)
                    return (Math.max(array1LeftElement,array2LeftElement) + Math.min(array1RightElement,array2RightElement))/2.0;
                else
                    return Math.max(array1LeftElement,array2LeftElement);
            }
        }

        return 0.0;
    }
}
/*
    1,3,5,6,9
    2,3,4,7

    total = 10
    median = 5

    int mid = 1
    if you need more element of 2nd grp decrease mid => when firstmax arr1 >secondMin arr2 
    else increase mid firstmax arr2> secondMin arr1

    odd median => max(firstMax,secondMax);
    even Median => max(firstMax,secondMax)+min(firstMin, secondMin) / 2;

    1,2,3,5,6
    4
    
    left = 3;
    right = 5
    totalElements= 3
    cut1 = 4
    cut2 = -1


    4
    1,2,3,5,6

    left = 0
    right = 1
    totalElements = 3
    cut1 = 0
    cut2 = 3
 */