class Solution {
    public long numberOfWeeks(int[] milestones) {
        if(milestones.length==1) return 1;

        long sum = 0;
        int maxi = 0;
        for(int  i :milestones)
        {
            maxi = Math.max(maxi,i);
            sum+=i;
        }

        long rest = sum-maxi;
        if(rest<maxi) return 2*rest+1;
        else return sum;

    }
}

/**
    
    last = 1  
    count = 7

    another way: if we sort array in ascending order : 1,2,5
                if 1 occurs one time , 2 will occur 2 time the next will occur 3 times
                [1,2,4,8]
                [2,3,5,9]
                [2,3,5]
                [0,0,0]
                mask= 1
                count = 5
                [0,1,3]
 */