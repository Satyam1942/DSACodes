class Solution {
    long getChildCount(long node, int limit){
        long neighbour = node+1;
        long noOfChild = 0;
        
        while(node<=limit) {
            noOfChild+= Math.min(neighbour,limit+1)-node;
            node*=10;
            neighbour*=10;
        }

        return noOfChild;
    }

    public int findKthNumber(int n, int k) {
        long node = 1;
        long pointer = 1;

        while(pointer<k){
            long noOfChildNodes = getChildCount(node,n);
            if(pointer+noOfChildNodes<=k) {
                pointer+=noOfChildNodes;
                node++;
            }else {
                pointer+=1;
                node*=10;
            }
        }

        long kthSmallestNumber = node;

        return (int)kthSmallestNumber;
    }
}