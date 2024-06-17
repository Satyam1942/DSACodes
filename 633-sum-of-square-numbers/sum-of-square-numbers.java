class Solution {
    public boolean judgeSquareSum(int c) {
       HashSet<Long> set = new HashSet<>();
       for(long i=0;i*i<=c;i++){
            if(set.contains(i*i)){
                return true;
            }
            if(c-i*i == i*i)
                return true;
            set.add(c-i*i);
       } 
       return false;
    }
}

/*
    101

 */