class Solution {
    int minimDistanceFromBikes(int bikeDistData[][], int bikeNo, int workersThatHaveBikes, Integer cache[][]) {
        if (bikeNo < 0)
        {
            if(workersThatHaveBikes==(1<<bikeDistData[0].length)-1) return 0;
            else return Integer.MAX_VALUE;
        }
        if (cache[bikeNo][workersThatHaveBikes] != null) return cache[bikeNo][workersThatHaveBikes];
        
        int minDistance = Integer.MAX_VALUE;
        int notGiveBike = minimDistanceFromBikes(bikeDistData, bikeNo - 1, workersThatHaveBikes,cache);

        if (bikeNo >= 0) {
            for (int index = 0; index < bikeDistData[bikeNo].length; index++) {
                if (((1 << index)&(workersThatHaveBikes)) > 0) continue;
                int temp = minimDistanceFromBikes(bikeDistData, bikeNo - 1,
                            workersThatHaveBikes|(1 << index), cache);

                if (temp != Integer.MAX_VALUE) temp += bikeDistData[bikeNo][index];
                minDistance = Math.min(minDistance, temp);
            }
        }
        minDistance = Math.min(minDistance, notGiveBike);

        return cache[bikeNo][workersThatHaveBikes] = minDistance;
    }

    int computeDistance(int coordinate1[], int coordinate2[]) {
        int x1 = coordinate1[0];
        int y1 = coordinate1[1];
        int x2 = coordinate2[0];
        int y2 = coordinate2[1];
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        int noOfWorkers = workers.length;
        int noOfBikes = bikes.length;
        int bikeDistData[][] = new int[noOfBikes][noOfWorkers];

        for (int i = 0; i < noOfBikes; i++) {
            for (int j = 0; j < noOfWorkers; j++) {
                bikeDistData[i][j] = computeDistance(bikes[i], workers[j]);
            }
        }

        Integer cache[][] = new Integer[noOfBikes][(1<<(noOfWorkers))];
        int bitmask =0;

        return minimDistanceFromBikes(bikeDistData, noOfBikes - 1, bitmask, cache);

    }
}
/*
    00000000000000000000000000011
    
 */