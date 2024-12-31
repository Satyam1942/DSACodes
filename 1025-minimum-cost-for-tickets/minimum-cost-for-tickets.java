class Solution {
    int getCost(int index, int maxLimitDay, int days[], int costs[], Integer cache[][]) {
        if(index==days.length) {
            return 0;
        }

        if(cache[index][maxLimitDay]!=null) {
            return cache[index][maxLimitDay];
        }

        if(days[index]<=maxLimitDay) {
            return cache[index][maxLimitDay] = getCost(index+1, maxLimitDay, days, costs, cache);
        }

        int oneDayPass = costs[0] + getCost(index+1, days[index], days, costs, cache);
        int sevenDayPass = costs[1] + getCost(index+1, days[index]+6, days, costs, cache);
        int thirtyDayPass = costs[2] + getCost(index+1, days[index]+29, days, costs, cache);
        
        return cache[index][maxLimitDay] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int length = days.length;
        int maxDay = days[length-1]+29;
        Integer cache[][] = new Integer[length][maxDay];
        return getCost(0, 0, days, costs, cache);
    }
}