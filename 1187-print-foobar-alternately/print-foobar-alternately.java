class FooBar {
    private int n;
    private boolean hasPrintedFoo;
    public FooBar(int n) {
        this.n = n;
        hasPrintedFoo = false;
    }

    public synchronized  void foo(Runnable printFoo) throws InterruptedException {
       
        for (int i = 0; i < n; i++) {
            while(hasPrintedFoo){
                wait();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            hasPrintedFoo = true;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!hasPrintedFoo){
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            hasPrintedFoo = false;
            notifyAll();
        }
    }
}