class ProductOfNumbers {
    List<Long> productStream;
    List<Integer> zeroCountStream;
    long product;
    int zeroCount;

    public ProductOfNumbers() {
        product = 1;
        zeroCount = 0;
        productStream = new ArrayList<>();
        zeroCountStream = new ArrayList<>();    
    }
    
    public void add(int num) {
        if(num==0) {
            zeroCount++;
            product = 1;
        } else {
            product*=num;
        }
        productStream.add(product);
        zeroCountStream.add(zeroCount);
    }
    
    public int getProduct(int k) {
        int size = productStream.size();
        int leftPointer = size-k;
        int rightPointer = size-1;
        int numberOfZeroes = (leftPointer==0)? zeroCountStream.get(rightPointer) : 
                                               zeroCountStream.get(rightPointer)-zeroCountStream.get(leftPointer-1);
        if(numberOfZeroes>0) {
            return 0;
        } else {
            long pro = (leftPointer==0)? productStream.get(rightPointer) :
                                         productStream.get(rightPointer)/productStream.get(leftPointer-1);
            return (int)pro;
        }
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */