class Solution {
    int getCeilIndex(int curElement, List<Integer> lis){
        int left = 0;
        int right = lis.size()-1;
        int ceilIndex = right;
        while(left<=right){
            int mid = (left+right)/2;
            if(lis.get(mid)>=curElement){
                right = mid-1;
                ceilIndex = mid;
            }else{
                left = mid+1;
            }
        }
        return ceilIndex;
    }

    public int maxEnvelopes(int[][] envelopes) {
        int noOfEnvelopes = envelopes.length;
        Arrays.sort(envelopes,(a,b)->((a[0]==b[0])?b[1]-a[1]:a[0]-b[0]));

        List<Integer> lis = new ArrayList<>();
        lis.add(envelopes[0][1]);

        for(int i=1;i<noOfEnvelopes;i++){
            int prevElement  = lis.get(lis.size()-1);
            int curElement = envelopes[i][1];
            if(prevElement < curElement)
                lis.add(envelopes[i][1]);
            else{
                int changeIndex = getCeilIndex(curElement,lis);
                lis.set(changeIndex,envelopes[i][1]);
            }
 
        }

        return lis.size();
    }
}
/*
   

 */