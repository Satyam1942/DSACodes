class Solution {
    public int numberOfWays(String corridor) {
        long mod = (long)(1e9+7);
        int length = corridor.length();
        int prefixSofa [] = new int[length];
        int prefixSum = 0;
        for(int i=0;i<length;i++)
        {
            if(corridor.charAt(i)=='S')prefixSum++;
            prefixSofa[i] = prefixSum;
        }

        if(prefixSum%2!=0 || prefixSum==0) return 0;

        long count = 1l;
        boolean flag = false;
        long temp = 0l;

        for(int i=0;i<length;i++)
        {
            if(prefixSofa[i]%2==0 && prefixSofa[i]!=0) {temp++; flag = true; }
            else if(flag)
            {
                count= (count*temp)%(mod);
                temp=0;
                flag = false;
            }
        }

        return (int)count;
    }
}
/*
    total Sofa = 4
    Total Plants = 3
    no of partitions = (totalSofa/2);
    no of dividers = no of partitons-1
    S S P P S P S P P P S S P S P S S P S 
    1 2 2 2 3 3 4 4 4 4 5 6 6 7 7 8 9 9 10
 */