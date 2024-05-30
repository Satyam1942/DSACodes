class Pair{
    int index, freq;
    Pair(int index, int freq){
        this.index = index;
        this.freq = freq;
    }
}

class Solution {
    public int countTriplets(int[] nums) {
        int length = nums.length;
        int prefixXor[] = new int[length];
        int xor = 0;
        for (int i = 0; i < length; i++) {
            xor ^= nums[i];
            prefixXor[i] = xor;
        }

        HashMap<Integer,Pair> seenXor = new HashMap<>();
        seenXor.put(0,new Pair(-1,1));
        int cache[] = new int[length+1];

        int count = 0;
        for(int i= 0;i<length;i++){
            int curXor = prefixXor[i];
            if(!seenXor.containsKey(curXor))
                seenXor.put(curXor,new Pair(i,1));
            else{
                int index = seenXor.get(curXor).index;
                int freq = seenXor.get(curXor).freq;
                int res = (freq-1)*(i-index)+ (i-index-1)+cache[index+1];
                cache[i+1] = res;
                count+= res;
                seenXor.put(curXor,new Pair(i,freq+1));
            }
        }

        return count;

    }
}