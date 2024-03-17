class Solution {

    public int[][] insert(int[][] interval, int[] newInterval) {
        
        int length = interval.length;
        if(length==0){
            int newArr[][] = new int[1][2];
            newArr[0] = newInterval;
            return newArr;
        }
        List<int[]> newIntervals = new ArrayList<>();
        
        boolean flag = false;
        int startIndex = 0;

        if(newInterval[0]<interval[0][0]){
            newIntervals.add(newInterval);
            flag = true;
            startIndex = 0;
        }else{
             newIntervals.add(interval[0]);
             startIndex = 1;
        }

        for(int i=startIndex;i<length;i++) {
            int prevIntervalStart  = newIntervals.get(newIntervals.size()-1)[0];
            int prevIntervalEnd   = newIntervals.get(newIntervals.size()-1)[1];
    
            if(!flag){

                if(newInterval[0]>=prevIntervalStart && newInterval[0]<=prevIntervalEnd ){
                    int mergedInterval[] = new int[2];
                    mergedInterval[0]= prevIntervalStart;
                    mergedInterval[1]= Math.max(prevIntervalEnd, newInterval[1]);
                    newIntervals.set(newIntervals.size()-1,mergedInterval);
                    flag = true;
                    i--;
                }else if(newInterval[0]<interval[i][0]){
                    //replacability with new one
                    newIntervals.add(newInterval);
                    flag = true;
                    i--;
                }else{
                    newIntervals.add(interval[i]);
                }

            }else{
      
                if(interval[i][0]>prevIntervalEnd) {
                    newIntervals.add(interval[i]);
                }
                else {
                    int mergedInterval[] = new int[2];
                    mergedInterval[0]= prevIntervalStart;
                    mergedInterval[1]= Math.max(prevIntervalEnd,interval[i][1]);
                    newIntervals.set(newIntervals.size()-1,mergedInterval);
                }
            }
        }


        if(!flag){
            int prevIntervalStart  = newIntervals.get(newIntervals.size()-1)[0];
            int prevIntervalEnd   = newIntervals.get(newIntervals.size()-1)[1];
            if(newInterval[0]>=prevIntervalStart && newInterval[0]<=prevIntervalEnd ){
                int mergedInterval[] = new int[2];
                mergedInterval[0]= prevIntervalStart;
                mergedInterval[1]= Math.max(prevIntervalEnd, newInterval[1]);
                newIntervals.set(newIntervals.size()-1,mergedInterval);
            }else{
                newIntervals.add(newInterval);
            }
        }

        
        int res[][] =new int[newIntervals.size()][2];
        
        for(int i =0;i<newIntervals.size();i++)
            res[i] = newIntervals.get(i);

         return res;
    }
}