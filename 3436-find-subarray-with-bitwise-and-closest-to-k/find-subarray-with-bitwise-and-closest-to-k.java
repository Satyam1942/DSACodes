class Solution {
    public int  addToFrequencyTable(int freq[], int num){
        int newNum =  0;
        for(int i=31;i>=0;i--){
            if((num&(1<<i))==0)
                freq[i]++;
        }
     
        for(int i=31;i>=0;i--){
            if(freq[i]==0)
                newNum|=(1<<i);
        }
       
        return newNum;
    }

    public int  removeFreqTable(int freq[], int num){
        int newNum =  0;
        for(int i=31;i>=0;i--){
            if((num&(1<<i))==0)
                freq[i]--;
        }
        
        for(int i=31;i>=0;i--){
            if(freq[i]==0)
                newNum|=(1<<i);
        }
       
        return newNum;
    }

    public int minimumDifference(int[] nums, int k) {
        int freq[] = new int[32];
        int length = nums.length;
        int left = 0, right = 0;

        int minDifference = Integer.MAX_VALUE;
        int andSlidingWindow = k;

        while(right<=length){

            if(left<right && andSlidingWindow<k){
                andSlidingWindow = removeFreqTable(freq,nums[left]);
                if(andSlidingWindow==-1)
                    andSlidingWindow = k;
                else
                   minDifference = Math.min(minDifference, Math.abs(k-andSlidingWindow));
                left++;
                continue;
            }

            if(right<length){
                andSlidingWindow = addToFrequencyTable(freq,nums[right]);
                minDifference = Math.min(minDifference, Math.abs(k-andSlidingWindow));
            }

            right++;
        }
        

        return minDifference;
    }
}
/*
1010
 110
 */