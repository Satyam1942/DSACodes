class Solution {
    public long numberOfWeeks(int[] milestones) {
        int maxi = 0;
        int length = milestones.length;
        long sum = 0; 

        for(int i=0;i<length;i++){
            maxi = Math.max(maxi,milestones[i]);
            sum+= (long)milestones[i];
        }

        sum-=maxi;
        if(maxi>sum)
            return 2l*sum+1;
        else
            return (long)(sum+maxi);

    }
}

/*
2
1
if(max>sum of rest)
    ans = sum of rest*2
else
    ans = total sum;
*/