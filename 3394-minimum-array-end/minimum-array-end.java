class Solution {
    public long minEnd(int n, int x) {
        long  minNum = 0;
        for(int i=0;i<31;i++){
            if((x&(1<<i))>0){
                minNum^=(1<<i);
            }
        }

        n--;
        long temp = x;
        int mask = 0;
        for(int i=0;i<31;){
            if((temp&(1l<<mask))==0){
                if((n&(1<<i))>0){
                    minNum ^= (1l<<mask);
                }
                i++;
            }
            mask++;
        }

        return minNum;
    }
}