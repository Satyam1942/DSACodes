class Solution {
    int costOfPainting(int index, int walls, int cost[], int time[], Integer cache[][] ) {
        if(walls<=0)
            return 0;
        if(index==cost.length)
            return Integer.MAX_VALUE;

        if(cache[index][walls]!=null)
            return cache[index][walls];

        int notPaint = costOfPainting(index+1,walls,cost,time,cache);
        int paint =  costOfPainting(index+1,walls-1-time[index],cost,time,cache);
        if(paint!=Integer.MAX_VALUE)
            paint+=cost[index];
        return cache[index][walls] = Math.min(paint,notPaint);
    }

    public int paintWalls(int[] cost, int[] time) {
        Integer cache[][] = new Integer[cost.length][cost.length+1];
        return costOfPainting(0,cost.length,cost,time,cache);
    }
}

/*
 * if(walls<=0)
 * return 0;
 * if(index==cost.length)
 * return Integer.MAX_VALUE;
 * int notPaint = costOfPainting(index+1,walls,cost,time);
 * int paint = cost[index] + costOfPainting(index+1,walls-1-time[index],cost,
 * time);
 * return min(paint,notPaint);
 */