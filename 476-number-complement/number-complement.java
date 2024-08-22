class Solution {
    public int findComplement(int num) {
        int msb = (int) Math.floor(Math.log(num) / Math.log(2)); 
        int newNum = 0;
        for(int j=msb;j>=0;j--){
            if((num&(1<<j))==0){
                newNum |= (1<<j);
            }
        }
        return newNum;
    }
}