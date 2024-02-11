class Solution {
    String stringifyPattern(int arr[]){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<arr.length;i++){
            if(arr[i]==-1){
                sb.append(2);
            }else
                sb.append(arr[i]);
        }
        return  sb.toString();
    }

     String stringifyNum(int arr[]){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<arr.length-1;i++){
            if((long)arr[i]<(long)arr[i+1])
                sb.append(1);
            else if(arr[i]==arr[i+1])
                sb.append(0);
            else 
                sb.append(2);
        }
        return  sb.toString();
    }


    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        String needle =  stringifyPattern(pattern);
        String haystack = stringifyNum(nums);

        // System.out.println(haystack);
        // System.out.println(needle);

         // KNUTH - MORRIS - PRATT (KMP) ALGORITHM

        if(m>n) return -1;
        
        //Building LPS array O(m)   worse case TC= O(2m)
        
        int lps[] = new int[m];
        int i=1;
        int prevLPS =0;

        while(i<m){
            if(needle.charAt(i)==needle.charAt(prevLPS)){
                lps[i]= prevLPS+1;
                prevLPS++;
                i++;
            }
            else if(prevLPS==0) {
                lps[i]=0; 
                i++;
            }
            else  
                prevLPS = lps[prevLPS-1];
        }


        //Iterating through haystack O(n)
        int count = 0;
         int right =0, left=0;
         while(right<n-1){
             if(haystack.charAt(right)== needle.charAt(left)){
                 right++;
                 left++;
             }
             else{
                 if(left==0)  
                    right++;
                 else  
                    left = lps[left-1];
            }

             if(left==m) {
                count++;
                left = lps[left-1];
             }
         }

         return count;

    }
}