class Solution {
   public int timeRequiredToBuy(int[] t, int k) {
    int noOfTickets = t.length;
    int time = 0;
    for(int i=0;i<noOfTickets;i++){
        if(i<=k)
            time+= Math.min(t[i],t[k]);
        else
            time+=Math.min(t[i],t[k]-1);
    }

    return time;

}
}

/*
    2,3,2
    3,2,1
    2,1,2
    1,2,1
    2,1
    1,1
    1

    for smallest numbers => (number-1)*(size) + (index+1)
    for 0th index 4=>1*3+1
    for 2nd index 6=>1*3+3

    for 2nd smallest numbers => ()*() + ()

    2,3,2
    2,2,3
    0,2,1
    4,6,
 */