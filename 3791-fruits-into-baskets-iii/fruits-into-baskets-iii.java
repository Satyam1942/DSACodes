class SegmentTree {
    int tree[];
    SegmentTree(int n) {
        tree = new int[4*n];
    }

    int buildTree(int left, int right, int index, int arr[]) {
        if(left==right) {
            return tree[index] = arr[left];
        }
        int mid = (left+right)/2;
        int a  = buildTree(left, mid, 2*index+1, arr);
        int b = buildTree(mid+1, right, 2*index+2, arr);
        return  tree[index] = Math.max(a,b);
    }

    int searchAndUpdate(int left, int right, int index, int key) {
        if(left==right) {
            if(tree[index]>=key) {
                System.out.println(tree[index] + " " + key);
                tree[index] = 0;
                return 0;
            } else {
                return -1;
            }
        }
        int mid = (left+right)/2;
        if(tree[index]>=key) {
            int val =  searchAndUpdate(left, mid, 2*index+1, key);
            if(val==-1) {
                val = searchAndUpdate(mid+1, right, 2*index+2, key);
                return tree[index] = Math.max(tree[2*index+1], val);
            } else {
                return tree[index] =  Math.max(tree[2*index+2], val);
            }
        } else {
            return -1;
        }
    }
}

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int length = baskets.length;
        SegmentTree segmentTree = new SegmentTree(length);
        segmentTree.buildTree(0, length-1, 0, baskets);
        int unplacedFruitCount = 0;
        for(int i=0;i <length; i++) {
            int basket = segmentTree.searchAndUpdate(0, length-1, 0, fruits[i]);
            if(basket==-1) {
                unplacedFruitCount++;
            }
        }
        return unplacedFruitCount;
    }
}

/*
    7
 6      7
6  4  
*/



