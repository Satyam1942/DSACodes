class Solution {
    public int findPeakElement(int[] arr) {
   //add code here.
   int n= arr.length;
       int left =0,right= n-1;
       int peak=0;
       if(arr.length==1) return 0;
       if(arr.length==2) return (arr[1]>arr[0])? 1:0;
       while(left<=right)
       {
           int mid = (left+right)/2;
           
           if(mid>0 && mid<n-1)
           {
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) return mid;
            else if(arr[mid]>=arr[mid+1] && arr[mid]<=arr[mid-1]) 
            {
               right = mid-1; 
               peak = mid-1;
               
            }
            
            else if(arr[mid]<=arr[mid+1] && arr[mid]>=arr[mid-1])
            {
            left = mid+1; 
            peak = mid+1;
            }
            else if(arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1]) {
                right = mid-1;
                peak = mid-1; 
            }
          }else if(mid==0){ return (arr[1]>arr[0])? 1:0;}
          
          else break;
           
       }
  
       return peak;

    }
}