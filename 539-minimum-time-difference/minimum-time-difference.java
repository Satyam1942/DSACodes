class Solution {
    public void convertToMins(List<Integer> minutes, List<String>timePoints) {
        int numberOfTimePoints = timePoints.size();
        for(String time : timePoints){
            int hour = Integer.valueOf(time.substring(0,2));
            int mins = Integer.valueOf(time.substring(3));
            int totalMins = hour*60+mins;
            minutes.add(totalMins);
        }
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        convertToMins(minutes,timePoints);
        Collections.sort(minutes);

        int numberOfTimePoints = timePoints.size();
        int numberOfMinsInDay = 1440;
        int minMinuteDifference = Integer.MAX_VALUE;

        for(int i=0;i<numberOfTimePoints-1;i++){
            int curDif =  minutes.get(i+1)-minutes.get(i);
            minMinuteDifference = Math.min(minMinuteDifference,curDif);
        }

        int curDif = (numberOfMinsInDay - minutes.get(numberOfTimePoints-1))+minutes.get(0);
        minMinuteDifference = Math.min(minMinuteDifference,curDif);
        return minMinuteDifference;
    }
}

/*
    convert time into mins
    ["23:59","00:00"] => [1439, 0]
    formula =>  hour * 60 + mins
    now  calc 2 differences
        i)dif1 = Maths.abs(t1-t2)
        ii)dif2 = 1440-Math.max(t2,t1)+Math.min(t2,t1)  where t2>t1
    get min of both
    get min for all pairs
 */