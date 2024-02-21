class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int mask = 0;
        for(int i=31;i>=0;i--){
            if(((left&(1<<i))>0) && ((right&(1<<i))>0)  ||
                ((left&(1<<i))==0) && ((right&(1<<i))==0))
                mask|=(left&(1<<i));
            else break;
        }

        return mask;
    }
}
/*

 */