class Solution {
    long mod = (long)(1e9+7);
    long rec(int n, char prev, Long  dp[][],HashMap<Character,Integer> map)
    {
        if(n==0) return 1;
        if(dp[n][map.get(prev)]!=null) return dp[n][map.get(prev)];

        long takeA = (prev=='\0'||prev=='e')?rec(n-1,'a',dp,map):0;
        long takeE = (prev=='\0'||prev=='a'||prev=='i')? rec(n-1,'e',dp,map):0;
        long takeI = (prev=='\0'||prev!='i')? rec(n-1,'i',dp,map):0;
        long takeO = (prev=='\0'||prev=='i' || prev=='u')?rec(n-1,'o',dp,map):0;
        long takeU = (prev=='\0'||prev=='a')? rec(n-1,'u',dp,map):0;

        return dp[n][map.get(prev)] = (takeA+takeE+takeI+takeO+takeU)%mod;
    }
    public int countVowelPermutation(int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('\0',0);
        map.put('a',1);
        map.put('e',2);
        map.put('i',3);
        map.put('o',4);
        map.put('u',5);

        Long dp[][] = new Long[n+1][6];
        return (int) (rec(n,'\0',dp,map)%mod);
    }
}

/*
    ea, ia, ua
    ae, ie,
    i
    o
    u
     */