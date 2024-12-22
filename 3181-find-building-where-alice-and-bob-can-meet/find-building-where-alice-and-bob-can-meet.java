class SegmentTree {
    int treeArr[];
    SegmentTree(int length) {
        treeArr = new int[4*length];
    }

    int buildTree(int sgTreeIndex, int leftIndex, int rightIndex, int arr[]) {
        if(leftIndex==rightIndex) {
           return  treeArr[sgTreeIndex] = arr[leftIndex];
        }

        int mid = (leftIndex+rightIndex)/2;
        int leftMax =  buildTree(2*sgTreeIndex+1, leftIndex, mid, arr); 
        int rightMax = buildTree(2*sgTreeIndex+2, mid+1, rightIndex, arr);
        return treeArr[sgTreeIndex] = Math.max(leftMax, rightMax); 
    }

    int fetchVal(int sgTreeIndex, int leftIndex, int rightIndex, int maxVal, int maxIndex) {
        if(treeArr[sgTreeIndex]<=maxVal) {
            return -1;
        }

        if(leftIndex==rightIndex) {
            return leftIndex;
        }

        int mid = (leftIndex+rightIndex)/2;
        int ans = -1;
        if(maxIndex<mid && treeArr[2*sgTreeIndex+1]>maxVal) {
            ans =  fetchVal(2*sgTreeIndex+1, leftIndex, mid, maxVal, maxIndex); 
        }

        if(ans!=-1) {
            return ans;
        }
        
        return fetchVal(2*sgTreeIndex+2, mid+1, rightIndex, maxVal, maxIndex);      
    }
}

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int length = heights.length;
        int numberOfQueries = queries.length;

        SegmentTree sgTree = new SegmentTree(length);
        sgTree.buildTree(0, 0, length-1, heights);

        int ans[] = new int[numberOfQueries];
        for(int i=0; i<numberOfQueries; i++) {
            int aliceIndex = queries[i][0];
            int bobIndex = queries[i][1];
            if(aliceIndex==bobIndex) {
                ans[i] = aliceIndex;
                continue;
            }
            
            int maxIndex = Math.max(aliceIndex, bobIndex);
            int maxVal = Math.max(heights[aliceIndex], heights[bobIndex]);
            if(heights[maxIndex]==maxVal && heights[aliceIndex]!=heights[bobIndex]) {
                ans[i] = maxIndex;
                continue;
            }
            int meetingIndex = sgTree.fetchVal(0, 0, length-1, maxVal, maxIndex);
            ans[i] = meetingIndex;
        }

        return ans;
    }
}

/*
    (6,0); (4,1); (8,2); (5,3); (2,4); (7,5)
    8,4
          2
        (0,5)
      2        2
    (0,2)    (3,5)
  2      1    2      2      
(0,1)    2  (3,4)     5
1   2         2   1   
0   1         3   4       

2
2
*/