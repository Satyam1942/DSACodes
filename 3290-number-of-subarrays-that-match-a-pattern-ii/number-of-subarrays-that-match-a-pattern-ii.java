class Solution {
    int[] modifyNum(int [] nums){
        int length = nums.length;
        int modifiedNum[] = new int[length-1];

        for(int i=0;i<length-1;i++){
            if(nums[i]<nums[i+1])
                modifiedNum[i] = 1;
            else if(nums[i]==nums[i+1])
                modifiedNum[i] = 0;
            else
                modifiedNum[i] = -1;
        }
        return modifiedNum;
    }

    int kmpAlgo(int nums[] , int pattern[]){
        int n = nums.length;
        int m = pattern.length;

        int lps[] = new int[m];
        lps[0]= 0;
        int prevLps = 0;
        int i = 1;

        while(i<m){
            if(pattern[prevLps]==pattern[i]){
                lps[i] = prevLps +1;
                prevLps++;
                i++;
            }else{
                if(prevLps==0){
                    lps[i] = 0;
                    i++;
                }else{
                    prevLps  = lps[prevLps-1];
                }
            }
        }
         
        i=0;
        int j=0;

        int count = 0;
        while(i<n){
            if(nums[i]==pattern[j]){
                i++;
                j++;
            }
            else{
                if(j==0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }

            if(j==m){
                count++;
                j=lps[j-1];
            }
        }

        return count;
    }

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int modifiedNum[] = modifyNum(nums);
        return kmpAlgo(modifiedNum,pattern);
    }
}