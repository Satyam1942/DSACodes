class Solution {
    public double findMedianSortedArrays(int[] a, int[]b) {
        int n =a.length;
        int m = b.length;
        
        if(m<n) return findMedianSortedArrays(b ,a);
        int totalLength = (n+m+1)/2;
        int left = 0, right = n;
        while(left<=right)
        {
            int cut1 = (left+right)/2;
            int cut2 = totalLength-cut1;

            int left1= (cut1==0)? Integer.MIN_VALUE: a[cut1-1];
            int left2= (cut2==0)? Integer.MIN_VALUE: b[cut2-1];
            int right1=(cut1==n)? Integer.MAX_VALUE: a[cut1];
            int right2=(cut2==m)? Integer.MAX_VALUE: b[cut2];

            if(left1<=right2 && left2<= right1)
            {
                if((n+m)%2==0){return ((double)(Math.max(left1,left2)+Math.min(right1,right2))/2);}
                else return Math.max(left1,left2);
            }else if(left1>right2) right =cut1-1;
            else left=cut1+1;

        }

        return 0.0;
   }
}