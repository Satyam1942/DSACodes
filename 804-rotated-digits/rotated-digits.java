class Solution {
    void getRotationMap(HashMap<Integer, Integer> rotationMap) {
        rotationMap.put(0, 0);
        rotationMap.put(1, 1);
        rotationMap.put(2, 5);
        rotationMap.put(5, 2);
        rotationMap.put(6, 9);
        rotationMap.put(8, 8);
        rotationMap.put(9, 6);
    }

    boolean isGoodNumber(int n, HashMap<Integer, Integer> rotationMap) {
        int x  = n;
        int newNum = 0;
        int mult = 1;
        while(x>0) {
            int d = x%10;
            if(!rotationMap.containsKey(d)) {
                return false;
            }
            d = rotationMap.get(d);
            newNum = mult*d + newNum;
            mult*=10;
            x =x/10;
        }
        return newNum!=n;
    }

    public int rotatedDigits(int n) {
        int count = 0; 
        HashMap<Integer, Integer> rotationMap = new HashMap<>();
        getRotationMap(rotationMap);
        for(int i=1; i<=n; i++) {
            if(isGoodNumber(i, rotationMap)) {
                count++;
            }
        }
        return count;

    }
}

/*

 */