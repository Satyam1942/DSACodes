class Solution {
    int sum(int index, int score, int rewardValues[], Integer cache[][]){
        if(index==rewardValues.length){
           return 0;
        }   
        if(cache[index][score]!=null)
            return cache[index][score];

        int take =0, notTake =0;
        if(rewardValues[index]>score)
            take  = rewardValues[index]+  sum(index+1, score+rewardValues[index],rewardValues , cache);

        notTake =  sum(index+1, score, rewardValues, cache);
        
        return cache[index][score] = Math.max(take,notTake);
    }

    public int maxTotalReward(int[] rewardValues) {
        int length = rewardValues.length;
        Arrays.sort(rewardValues);
        Integer cache[][] = new Integer[length][4000];
        return sum(0,0,rewardValues,cache);
    }
}

/*
    1,1,3,3
    1,2,3,4,6
    if I dont pick smallest number I will never be able to pick it up
    x1, x2, x3, x4,......,largest
    score = x1+x2+x3+x4
    x1+x2+x3+x4>largest and I know all xi are <largest
    I know this  x1+x2+x3<largest
    so obviously I will pick x1+x2+x3+largest and this will be my maximum sum since x4<largest
    (Exchange argument)

    So largest will always be in my answer array
    1,2,3,4,6
    so 6 will be in my answer
    1,2,3,4
*/