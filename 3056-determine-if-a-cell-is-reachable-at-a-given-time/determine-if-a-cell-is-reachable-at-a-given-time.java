class Solution {
    
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(fx==sx && fy==sy) return t>1||t==0;
        
       int dif1 = Math.abs(fx-sx) ;
       int dif2  = Math.abs(fy-sy) ;
       int extra = Math.min(dif1,dif2);

        int minTime = extra + Math.max(Math.abs(dif1-extra),Math.abs(dif2-extra));
        return t>=minTime;
    }
}