class Solution {
    //Manacher's Algo
    public String longestPalindrome(String s) {
        int length = s.length();
        int centre = 0;
        int right = 0;
        int cache[] = new int[2*length+1];

        s = s.replace("","#");
    
        for(int i=0;i<2*length+1;i++){
            if(i<right){
                cache[i] = Math.min(right-i,cache[centre-(i-centre)]);
            }

            while(i+1+cache[i]<s.length() && i-1-cache[i]>=0 && s.charAt(i+1+cache[i])==s.charAt(i-1-cache[i])){
                cache[i]++;
            }

            if(i+cache[i]>right){
                right = i+cache[i];
                centre = i;
            }
        }

        int maxIndex =0, maxLen = 0;
        for(int i=0;i<cache.length;i++){
            if(cache[i]>maxLen){
                maxLen = cache[i];
                maxIndex = i;
            }
        }

        String  ans = s.substring(maxIndex-maxLen,maxIndex+maxLen+1).replace("#","");
        return ans;
    }
}