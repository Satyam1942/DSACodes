class ProductOfNumbers {

	List<Integer> stream;
    public ProductOfNumbers() {
      stream = new ArrayList<>();
    }
   
    public void add(int num) {
       if(num==0)stream.clear();
	  else if(stream.size()==0) stream.add(num);
	 else 
	 { 
	 int prev = stream.get(stream.size()-1);
	 stream.add(num*prev);
	 }
    }
    public int getProduct(int k) {
	int size = stream.size();
	 if(k>size) return 0;
	 else if(k==size) return stream.get(size-1);
	 else return stream.get(size-1)/stream.get(size-k-1);
  }
}
