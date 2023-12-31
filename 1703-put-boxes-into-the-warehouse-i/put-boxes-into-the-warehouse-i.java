class Solution {
    boolean isPossibleToStoreBoxes(int warehouse[], int boxes[], int noOfBoxes)
    {
	int boxCount = 0;
	int length = warehouse.length;
	int totalBoxes = boxes.length;

	int i= length-1, j =0;
	while(i>=0 && j<totalBoxes)
	{
		int heightOfWarehouse = warehouse[i];
        int heightOfBox = boxes[j];
		if(heightOfBox<=heightOfWarehouse) 
        {
        boxCount++;
	    j++;
        }
        i--;
    }   

    return boxCount>=noOfBoxes && length>=noOfBoxes;
    }

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int length = warehouse.length;
        int maximumSizeOfBox[] = new int[length];
        int minimumHeightOfBox = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            minimumHeightOfBox = Math.min(minimumHeightOfBox, warehouse[i]);
            maximumSizeOfBox[i] = minimumHeightOfBox;
        }
        
        int totalBoxes = boxes.length;
        int left = 0;
        int right = totalBoxes;
        int maximumBoxes = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossibleToStoreBoxes(maximumSizeOfBox, boxes, mid)) {
                left = mid + 1;
                maximumBoxes = mid;
            } else
                right = mid - 1;
        }

        return maximumBoxes;

    }
}
/*
    [5,3,3,4,1]
     5,3,3,,
     ,,4,4
 */