class Solution {
    public boolean checkIfExist(int[] arr) {
        int length = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<length;i++) {
            int num = arr[i];
            if(set.contains(num*2)) {
                return true;
            }
            if(num%2==0 && set.contains(num/2)) {
                return true;
            }
            set.add(num);
        }  
        
        return false;
    }
}