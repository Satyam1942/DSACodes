class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalRolls = m+n;
        int totalSum = mean*totalRolls;

        int sumOfMValues = 0;
        for(int i=0;i<m;i++)
            sumOfMValues+=rolls[i];
        int missingSum = totalSum-sumOfMValues;
        int avgValue = (int)Math.ceil(missingSum/(double)n);

        if(avgValue>6 || avgValue<1)
            return new int[0]; // impossible
        
        int unknownValueArray[] = new int[n];
        Arrays.fill(unknownValueArray,avgValue);
        
        if(missingSum%n!=0){
            int extraSum = avgValue*n-missingSum;
            if(extraSum>n || avgValue==1)
                return new int[0];
            for(int i=0;i<extraSum;i++)
                unknownValueArray[i]--;
        }

        return unknownValueArray;
    }
}

/*
    n+m  dice rolls
    min sum => n+m;
    max Sum => 6*(n+m)
    m rolls values are given 
    to find n rolls values
    
    total rolls = m+n = rolls.length+n
    total Sum = mean*(total rolls)
    missing Sum = total Sum - sum of  rolls array 

    now we have to find n numbers such  that sum of n numbers = missing Sum
    and make sure each number is in between 1 and 6

    if(missingSum>6n || missingSum<n)
        return impossible 
    
    if possible


    simple!!

    12
*/