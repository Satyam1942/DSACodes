class Solution {
    public int countDays(int days, int[][] meetings) {
        int length =  meetings.length;
        Arrays.sort(meetings,(a,b)->(a[0]-b[0]));
        List<int[]> mergedInterval = new ArrayList<>();
        mergedInterval.add(meetings[0]);
        
        for(int i=1;i<length;i++){
            if(mergedInterval.get(mergedInterval.size()-1)[1]<meetings[i][0]){
                mergedInterval.add(meetings[i]);
            }else{
                int temp[] = new int[2];
                temp[0] = mergedInterval.get(mergedInterval.size()-1)[0];
                temp[1] = Math.max(mergedInterval.get(mergedInterval.size()-1)[1],meetings[i][1]);
                mergedInterval.set(mergedInterval.size()-1,temp);
            }
        }
        
        long count = mergedInterval.get(0)[0]-1;
        for(int i=0;i<mergedInterval.size()-1;i++){
            count+= (long)mergedInterval.get(i+1)[0]-(long)mergedInterval.get(i)[1]-1;
        }
        count += (long)days-(long)mergedInterval.get(mergedInterval.size()-1)[1];
        
        return (int)count;
    }
}