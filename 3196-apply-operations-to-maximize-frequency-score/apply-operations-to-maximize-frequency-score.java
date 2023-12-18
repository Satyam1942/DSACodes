class Solution {
    
    boolean isPossible(int [] nums, long k , int mid ,long prefixSum[],  HashMap<Integer,Integer> map)
    {
        long totalTurns = Long.MAX_VALUE;
        int length = nums.length;
        
        int i = 0, j = i+mid-1;
       
        while(j<length)
        {
            int median = nums[(i+j)/2];
            int medianIdx = Math.max(i,map.get(median));
            long temp = 0l;
            if(i-1>=0)  
            temp =  ((prefixSum[j]-prefixSum[i-1])-2*(prefixSum[medianIdx-1]-prefixSum[i-1]))+
                    (median*(medianIdx-i))-(median*(j-medianIdx+1)); 
            else if(medianIdx-1>=0) 
            temp = (prefixSum[j]-2*(prefixSum[medianIdx-1]))+
                    (median*(medianIdx-i))-(median*(j-medianIdx+1)); 
            else temp = prefixSum[j]+ (median*(medianIdx-i))-(median*(j-medianIdx+1)); 
            
            totalTurns = Math.min(totalTurns,temp);
            i++;
            j++;
        }
        
        System.out.println(mid+" "+totalTurns);
        return totalTurns<=k;
    }
    
    public int maxFrequencyScore(int[] nums, long k) {
        
        Arrays.sort(nums);
        int length = nums.length;
        long prefixSum[] = new long[length];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        long sum = 0l;
        for(int i=0;i<length;i++)
        {
                sum+=nums[i];
            prefixSum[i] = sum;
            if(!map.containsKey(nums[i])) map.put(nums[i],i);
        }
        
        
        int left = 1;
        int right = nums.length;
        int ans = left;
        
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(isPossible(nums,k,mid,prefixSum,map)){left = mid+1; ans = mid; }
            else  right = mid-1;
        }
        
        return ans;
    }
}


/*
    1,2,4,4,4 ; k=0;
    2, 3, 3, 8, 13, 13, 15, 19, 19, 20, 20, 21, 24 ;  k=45; 
    2, 5, 8,16, 29, 42, 57, 76, 95,115, 135,156,180

    13-2 
    13-3
    13-3
    13-8

    13-13
    13-13
    15-13
    19-13
    19-13
    20-13
    20-13
    
    135-16 = 119-16

    1,2,4,4,4
    1,3,7,11,15

    4-4
    4-4
    4-4
*/