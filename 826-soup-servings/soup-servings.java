class Solution {
    double probabilityAUsedUpWithB(int a, int b, Double cache[][]) {
        if(a==0 && b==0) {
            return 1;
        }
        if(a==0 || b==0) {
            return 0;
        }
        if(cache[a][b]!=null) {
            return cache[a][b];
        }
        double posA = 0.25 * probabilityAUsedUpWithB(Math.max(a-100,0), b, cache);
        double posB = 0.25 * probabilityAUsedUpWithB(Math.max(a-75,0), Math.max(b-25,0), cache);
        double posC = 0.25 * probabilityAUsedUpWithB(Math.max(a-50,0), Math.max(b-50,0), cache);
        double posD = 0.25 * probabilityAUsedUpWithB(Math.max(a-25,0), Math.max(b-75,0), cache);
        return cache[a][b] = posA+posB+posC+posD;
    }

    double probabilityAUsedBeforeB(int a, int b, Double cache[][]) {
        if(b==0) {
            return 0;
        }
        if(a==0 && b>0) {
            return 1;
        }
        if(cache[a][b]!=null) {
            return cache[a][b];
        }
        double posA = 0.25 * probabilityAUsedBeforeB(Math.max(a-100,0), b, cache);
        double posB = 0.25 * probabilityAUsedBeforeB(Math.max(a-75,0), Math.max(b-25,0), cache);
        double posC = 0.25 * probabilityAUsedBeforeB(Math.max(a-50,0), Math.max(b-50,0), cache);
        double posD = 0.25 * probabilityAUsedBeforeB(Math.max(a-25,0), Math.max(b-75,0), cache);
        return cache[a][b] = posA+posB+posC+posD;
    }

    public double soupServings(int n) {
        if(n>=10000) {
            return 1;
        }
        Double cache[][] = new Double[n+1][n+1];
        double res1 = probabilityAUsedBeforeB(n,n, cache);
        cache = new Double[n+1][n+1];
        double res2 = probabilityAUsedUpWithB(n,n, cache);
        return res1+0.5*res2;
    }
}

/*
    n   n

*/