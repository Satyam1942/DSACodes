class Solution {
    public int totalMoney(int n) {
        int quotient = n/7;
        int remainder = n%7;
        int s1 = ((remainder*(remainder+1))/2)+ quotient*remainder;
        int s2 = (quotient * (56+(quotient-1)*7))/2;

        return s1+s2;
    }
}
/*
    28 , 35,
    
 */