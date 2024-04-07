class H2O {
    private int countHydrogenAtoms;
    public H2O() {
        countHydrogenAtoms = 0;
    }

    public synchronized  void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		while(countHydrogenAtoms==2)
            wait();

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        countHydrogenAtoms++;
        notifyAll();
    }

    public synchronized  void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while(countHydrogenAtoms!=2)
            wait();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        countHydrogenAtoms = 0;
        notifyAll();
    }
}