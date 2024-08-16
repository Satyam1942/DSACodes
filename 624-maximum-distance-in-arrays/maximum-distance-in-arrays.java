class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int[] smallestNo = new int[]{Integer.MAX_VALUE,-1};
        int[] secondSmallestNo = new int[]{Integer.MAX_VALUE,-1};
        int[] largestNo = new int[]{Integer.MIN_VALUE,-1};
        int[] secondLargestNo = new int[]{Integer.MIN_VALUE,-1};
        
        for(int i=0;i<arrays.size();i++){
            List<Integer> array = arrays.get(i);
            int lengthOfArray = array.size();

            if(smallestNo[0]>array.get(0)){
                secondSmallestNo[0] = smallestNo[0];
                secondSmallestNo[1] = smallestNo[1];
                smallestNo[0] = array.get(0);
                smallestNo[1] = i;
            }else if(secondSmallestNo[0]>array.get(0)){
                secondSmallestNo[0] = array.get(0);
                secondSmallestNo[1] = i;
            }

            if(largestNo[0]<array.get(lengthOfArray-1)){
                secondLargestNo[0] = largestNo[0];
                secondLargestNo[1] = largestNo[1];
                largestNo[0] = array.get(lengthOfArray-1);
                largestNo[1] = i;
            }else if(secondLargestNo[0]<array.get(lengthOfArray-1)){
                secondLargestNo[0] = array.get(lengthOfArray-1);
                secondLargestNo[1] = i;
            }
        }

        if(largestNo[1]!=smallestNo[1])
            return largestNo[0]-smallestNo[0];
        else 
            return Math.max(largestNo[0]-secondSmallestNo[0],secondLargestNo[0]-smallestNo[0]);

    }
}
/*
    1   2   3
    4   5
    1   2   3

 */