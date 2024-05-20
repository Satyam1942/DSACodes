class Solution {
    int noOfChangesRequired(String answerKey, int maxLength, char token){
        int answerKeyLength = answerKey.length();
        int noOfChanges = 0;
        int left = 0, right = maxLength-1;

        for(int i=left;i<=right;i++){
            char ans = answerKey.charAt(i);
            if(ans==token)
                 noOfChanges++;
        }
   
        int minChanges = noOfChanges;
        while(right<answerKeyLength){
            if(answerKey.charAt(left)==token)
                noOfChanges--;
            left++;
            right++;
            if(right<answerKeyLength){
                if(answerKey.charAt(right)==token)
                    noOfChanges++;
                minChanges = Math.min(minChanges,noOfChanges);
            }
        }
        return minChanges;
    }

    boolean isPossible(int maxChanges, int maxLength, String answerKey){
        int noOfChangesTrue = noOfChangesRequired(answerKey,maxLength,'F');
        int noOfChangesFalse = noOfChangesRequired(answerKey,maxLength,'T');
        return maxChanges>=Math.min(noOfChangesTrue,noOfChangesFalse);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
       int length = answerKey.length();
       int left = 1;
       int right =  length;
       int ans = left;
       while(left<=right){
            int mid = (left+right)/2;
            if(isPossible(k,mid,answerKey)){
                ans = mid;
                left = mid+1;
            }else
                right = mid-1;
       }
       return ans;
    }
}