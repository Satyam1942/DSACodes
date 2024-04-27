class Pair{
    int index, distance;
    Pair(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
    @Override
    public String toString(){
        return "["+index + ","+distance+"]";
    }
}
class Solution {
    void calculateDistance(HashMap<Character,List<Pair>>[] distance, String ring){
        int length = ring.length();
      
        for(int i=0;i<length;i++){
            distance[i] = new HashMap<>();
            for(int j=0;j<length;j++){
                char curChar = ring.charAt(j);
                int dist = Math.abs(j-i);

                if(dist>length/2)
                    dist = length - dist;
                if(!distance[i].containsKey(curChar))
                    distance[i].put(curChar, new ArrayList<>());

                distance[i].get(curChar).add(new Pair(j,dist));
            }
        }
    }

    int minimumSteps(int ringIndex, int keyIndex, String key, HashMap<Character,List<Pair>>[] distance ,Integer cache[][]){
        if(keyIndex==key.length())
            return 0;
        if(cache[ringIndex][keyIndex]!=null)
            return cache[ringIndex][keyIndex];

        char curToken = key.charAt(keyIndex);
        List<Pair> temp = distance[ringIndex].get(curToken);

        int minDist = Integer.MAX_VALUE;
        for(int i=0;i<temp.size();i++){
            int nextIndex = temp.get(i).index;
            int tempDist = 1+temp.get(i).distance +  minimumSteps(nextIndex,keyIndex+1,key,distance,cache);
            minDist = Math.min(minDist,tempDist);
        }

        return cache[ringIndex][keyIndex] = minDist;
    }

    public int findRotateSteps(String ring, String key) {
        int length = ring.length();
        HashMap<Character,List<Pair>>[] distance = new HashMap[length];
        Integer cache[][] = new Integer[ring.length()][key.length()];
        calculateDistance(distance,ring);

        return minimumSteps(0,0,key,distance,cache);
    }   
}
/*       g                  o  d  i  n
    0=>  (0,0) (6,1)        
    Store distance in above fashion

    This is a DP question
    We can use recursion

    int indexRing , int indexKey, 
    inner loop for loop in the distance array  
 */