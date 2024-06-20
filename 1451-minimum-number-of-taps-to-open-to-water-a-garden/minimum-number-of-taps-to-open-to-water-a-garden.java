class Tap implements Comparator<Tap>{
    int start;
    int end;

    Tap(){

    }

    Tap(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compare(Tap a, Tap b){
        if(a.start==b.start)
            return b.end-a.end;
        else
            return a.start-b.start;
    }

    @Override
    public String toString(){
        return "["+start+","+end+"]";
    }
}

class Solution {
    public int minTaps(int n, int[] ranges) {
        Tap tap[] = new Tap[n+1];
        for(int i=0;i<=n;i++){
            int end = i+ranges[i];
            int start = Math.max(0,i-ranges[i]);
            tap[i] = new Tap(start,end); 
        }

        Arrays.sort(tap,new Tap());
        int maxEnd = tap[0].end;
        int minCount = 1;
        // System.out.println(Arrays.toString(tap));

        for(int i=1;i<=n;){
            if(maxEnd>=n)
                break;
                
            int newMaxEnd = maxEnd;
            while(i<=n && tap[i].start<=maxEnd){
                newMaxEnd = Math.max(newMaxEnd,tap[i].end);
                i++;
            }
         
            if(newMaxEnd==maxEnd)
                return -1;

            maxEnd = newMaxEnd;
            minCount++;
        }


        return minCount;
    }
}

/*
    
    [0,5]
    [0,3]
    [1,3]
    [2,4]
    [4,4]
    [5,5]

    [0,5]

*/