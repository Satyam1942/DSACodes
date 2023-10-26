class Pair
{
    int factor1 , factor2;
    Pair(int factor1, int factor2)
    {
        this.factor1 = factor1;
        this.factor2 = factor2;
    }
}
class Solution {

    long mod = (long)(1e9+7);

long rec(int root, HashMap<Integer,List<Pair>> map,HashMap<Long,Integer> indexMap, Long dp[])
    {
        int index = indexMap.get((long)root);
        if(dp[index]!=null) return dp[index];

        if(!map.containsKey(root)) return dp[index] = 1l;
        else
        {
            List<Pair> listOfFactors = map.get(root);
            long ans = 1l;
            for(int i=0;i<listOfFactors.size();i++)
            {
                int factor1 = listOfFactors.get(i).factor1;
                int factor2 = listOfFactors.get(i).factor2;

                ans+=(rec(factor1,map,indexMap,dp)*rec(factor2,map,indexMap,dp));
            }
            return dp[index] = ans;
        }
    }

    public int numFactoredBinaryTrees(int[] arr) {
    int length = arr.length;
    Long dp[] = new Long[length];
    HashMap<Integer, List<Pair>> map = new HashMap<>();
    HashMap<Long,Integer> indexMap = new HashMap<>();

    for(int i=0;i<length;i++) indexMap.put((long)arr[i],i);

    for(int i=0;i<length;i++)
    {
        for(int j = 0;j<length;j++)
        {
            int factor1 = arr[i];
            int factor2 = arr[j];
            long product =  (long)factor1*(long)factor2;
            if(indexMap.containsKey(product))
            {
            if(!map.containsKey((int)product)) map.put((int)product,new ArrayList<>());
            map.get((int)product).add(new Pair(factor1, factor2));
            }
        }
    }

    long noOfTrees = 0;

    for(int i=0;i<length;i++)
    {
        int root = arr[i];
        noOfTrees +=  rec(root,map,indexMap,dp);
    }
    return (int)(noOfTrees%mod);

    }
}

/*
[2,4,5,10]
    4-{(2,2)}
    8-{(2,4),(4,2)}
    10-{(2,5),(5,2)}
 */