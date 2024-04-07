class ZeroEvenOdd {
    private int n;
    private boolean zeroTurn;
    private boolean oddTurn;
    private boolean evenTurn;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroTurn = true;
        oddTurn = false;
        evenTurn = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!zeroTurn)
                wait();

            printNumber.accept(0);
            zeroTurn = false;
            oddTurn = !oddTurn;
            evenTurn = !evenTurn;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (zeroTurn || oddTurn)
                wait();
            printNumber.accept(i);
            zeroTurn = true;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (zeroTurn || evenTurn)
                wait();

            printNumber.accept(i);
            zeroTurn = true;
            notifyAll();
        }
    }
}