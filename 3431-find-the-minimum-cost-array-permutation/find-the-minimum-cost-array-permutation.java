class Solution {
    
    int formPermutation(int prev, int bitmask , int nums[], int n, Integer cache[][], Integer permutation[][]){
        if(Integer.bitCount(bitmask)==n){
            return Math.abs(prev-nums[0]);
        }

        if(cache[prev][bitmask]!=null)
            return cache[prev][bitmask];

        int minScore = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if((bitmask&(1<<i))>0)
                continue;
            int score = Math.abs(prev-nums[i])+ formPermutation(i,bitmask^(1<<i),nums,n,cache, permutation);
            if(score<minScore){
                minScore = score;
                permutation[prev][bitmask] = i;
            }
            
        }

        return cache[prev][bitmask] = minScore;
    }

    public int[] findPermutation(int[] nums) {
        int length = nums.length;
        int permutation[] = new int[length];
        Integer cache[][] = new Integer[length][(1<<14)];
        Integer val[][] = new Integer[length][(1<<14)];
        
        formPermutation(0,1,nums,length,cache,val);
        
        int pointer = 0;
        permutation[0] = 0;
        for(int i=1;Integer.bitCount(i)<length;i+=(1<<permutation[pointer])){
            pointer++;
            permutation[pointer] = val[permutation[pointer-1]][i];
        }
        
        return permutation;
    }
}

/*
[1,0,2]
[1,0,]


KEY OBSERVATION:
We can start with any number. The cost does not change if we rotate the result array; 
only the order matter, not the position.
*/