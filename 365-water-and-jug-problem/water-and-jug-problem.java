class Solution {
    boolean search(HashSet<Integer>list[], int targetCapacity,
        int jug1Capacity, int jug2Capacity, int vis[]){

        if(vis[targetCapacity]==1) return false;
        else vis[targetCapacity] = 1;

        int dif1 = Math.abs(targetCapacity - jug1Capacity);
        int dif2 = Math.abs(targetCapacity- jug2Capacity);

        if(list[1].contains(dif1) || list[0].contains(dif2)) return true;
        
        boolean s1 = search(list,dif1,jug1Capacity,jug2Capacity,vis);
        boolean s2 = search(list,dif2,jug1Capacity,jug2Capacity,vis);

        return s1||s2;
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {   
            
            if(jug1Capacity>jug2Capacity) 
                return canMeasureWater(jug2Capacity,jug1Capacity,targetCapacity);

            if(targetCapacity>jug1Capacity+jug2Capacity) return false;

            HashSet<Integer> list [] = new HashSet[2];
            list[0] = new HashSet<>();
            list[1] = new HashSet<>();
            
            list[0].add(jug1Capacity);
            list[1].add(jug2Capacity);
            
            int second = jug2Capacity;
            int first = jug1Capacity;
            int dif = jug2Capacity-jug1Capacity;
            boolean flag = true;

            while(dif<=0)
            {
                if(flag) list[0].add(dif);
                else list[1].add(dif);
                
                flag=!flag;

                if(first>dif)
                {
                second = first;
                first = dif;
                }
                else second = dif;
            
                dif = second-first;
            }

            int vis[] = new int[(int)(1e6)];
            return search(list,targetCapacity,jug1Capacity,jug2Capacity,vis);
    }
}

/*
1) Fill the 5 gallon/Pour into the 3 gallon
2) Empty the 3 gallon
3) Pour 2 remaining into the 3 gallon
4) Refill 5 gallon 
5) Pour a bit from 5 gallon into 3 gallon. 

5-5,2,1
3-3,1
 */
