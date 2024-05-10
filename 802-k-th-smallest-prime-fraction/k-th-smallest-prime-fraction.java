class Triplet implements Comparator<Triplet> {
    int numerator;
    int denominator;
    double fraction;

    Triplet() {
    }

    Triplet(int numerator, int denominator, double fraction) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.fraction = fraction;
    }

    @Override
    public int compare(Triplet a, Triplet b) {
        return Double.compare(a.fraction, b.fraction);
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int length = arr.length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>(new Triplet());

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int numerator = arr[i];
                int denominator = arr[j];
                double fraction = numerator / (double) denominator;
                pq.add(new Triplet(numerator, denominator, fraction));
            }
        }

        while (k-- > 1)
            pq.poll();

        int ans[] = new int[2];
        ans[0] = pq.peek().numerator;
        ans[1] = pq.peek().denominator;
        return ans;

    }
}