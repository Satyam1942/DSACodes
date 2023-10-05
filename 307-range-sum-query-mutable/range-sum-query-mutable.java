class Node
{
    int sum;
    int left ,right;
    Node leftLink , rightLink ;
    Node(int sum , int left ,int right)
    {
        this.sum = sum;
        this.left = left ;
        this.right = right;
        this.leftLink = null;
        this.rightLink = null;
    }
}

class SegmentTree
{
    int nums[];
    SegmentTree(int nums[])
    {
        this.nums = nums;
    }
    public Node createTree(int left, int right)
    {
        if(left==right) return new Node(nums[left],left,right);
    
        int mid = (left+right)/2;
        Node lNode = createTree(left,mid);
        Node rNode = createTree(mid+1,right);
        
        Node newNode  = new Node(lNode.sum+ rNode.sum, lNode.left, rNode.right);
        newNode.leftLink = lNode;
        newNode.rightLink = rNode ;
        return newNode;
        
    }
    
    public int find(Node node, int left, int right)
    {
        if(node==null) return 0;
        if(left==node.left && right==node.right) return node.sum;

        int mid = (node.left+node.right)/2;
        if(left<=mid && right<=mid) return find(node.leftLink,left,right);
        else if(left>mid && right>mid) return find(node.rightLink,left,right);
        else if(left<=mid && right>mid) return find(node.leftLink,left,mid) + 
                                                find(node.rightLink,mid+1,right);
        return -1;
    }

    public void update(Node node , int index, int oldVal ,int newVal)
    {
        if(node == null) return;

        if(index>=node.left && index<=node.right) node.sum+= newVal-oldVal;

        int mid = (node.left+node.right)/2;
        if(index<=mid) update(node.leftLink,index,oldVal,newVal);
        else if(index>mid) update(node.rightLink, index, oldVal, newVal);
    }
}

class NumArray {
    Node node;
    SegmentTree sgt;
    int nums[];
    public NumArray(int[] nums) {
        this.nums = nums;
        sgt = new SegmentTree(nums);
        node = sgt.createTree(0,nums.length-1);
    }
    
    public void update(int index, int val) {
        sgt.update(node,index,nums[index],val);
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return sgt.find(node,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */