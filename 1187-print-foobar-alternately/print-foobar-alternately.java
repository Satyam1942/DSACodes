class FooBar {
    private int n;
    private Semaphore runFoo, runBar;
    public FooBar(int n) {
        this.n = n;
        runFoo = new Semaphore(1);
        runBar = new Semaphore(0);
    }

    public  void foo(Runnable printFoo) throws InterruptedException {
       
        for (int i = 0; i < n; i++) {
            runFoo.acquire();
        	printFoo.run();
            runBar.release();
        }
    }

    public  void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            runBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            runFoo.release();
        }
    }
}