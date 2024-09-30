class CustomStack {
    int stackArray[];
    int valToIncrement;
    int pointerToIncrement;
    int top;
    int maxSize;

    public CustomStack(int maxSize) {
        stackArray = new int[maxSize];
        valToIncrement = 0;
        pointerToIncrement = 0;   
        this.maxSize = maxSize;
        top  = -1; 
    }
    
    public void push(int x) {
        top++;
        if(top<maxSize) {
            stackArray[top] = x;
        } else {
            top = maxSize-1;
        }
    }
    
    public int pop() {
        if(top<0) {
            return -1;
        } else {
            int element = stackArray[top];
            top--;
            return element;
        }
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<Math.min(k,top+1);i++){
            stackArray[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */