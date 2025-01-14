class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        HashSet<Integer> set = new HashSet<>();
        int n = A.length,cnt=0;
       int [] output = new int[n];
        for(int i=0;i<n;i++) {
            if(set.contains(A[i])) cnt++;
            if(set.contains(B[i])) cnt++;
            
            if(A[i]==B[i]) output[i] = ++cnt; 
            else output[i] = cnt;
            
            set.add(A[i]);
            set.add(B[i]);
        }
        return output;
        
    }
}