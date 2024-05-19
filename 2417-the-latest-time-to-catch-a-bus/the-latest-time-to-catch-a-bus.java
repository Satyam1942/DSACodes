class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i=0,j=0;
        
        int res = 0;
        for( i=0;i<buses.length;i++){
            int tempCapacity = capacity;
            while(j<passengers.length && passengers[j]<=buses[i] && tempCapacity>0){
                j++;
                tempCapacity--;
            }

            if(i==(buses.length-1)){
                j--;
                if(tempCapacity>0){
                    int time = buses[i];
                    while(j>=0 && passengers[j]==time){
                        j--;
                        time--;
                    }
                    res = time;
                }else{
                    int time = passengers[j]-1;
                    j--;
                    while(j>=0 && passengers[j]==time){
                        j--;
                        time--;
                    }
                   
                    res = time;
                }
            }
        }
        

      
        return res;
    }
}