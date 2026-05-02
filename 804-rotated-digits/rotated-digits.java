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

    int countGoodNumber(int index, int restricted, int notEqual, int[] num, HashMap<Integer, Integer> rotationMap, Integer cache[][][]) {
        if(index == num.length) {
            if(notEqual == 1) {
                return 1;
            } else {
                return 0;
            }
        }

        if(cache[index][restricted][notEqual]!=null) {
            return cache[index][restricted][notEqual];
        }

        int limit = (restricted==1)? num[index] : 9;
        int count = 0;
        for(Map.Entry<Integer, Integer> i: rotationMap.entrySet()) {
            if(i.getKey()>limit) {
                continue;
            }
            int isNotSameDigit = (i.getValue()==i.getKey()) ? 0 : 1;
            int isSame = (i.getKey()==num[index])? 1:0 ;
            int newRestricted = Math.min(restricted, isSame);
            int newNotEqual = Math.max(notEqual, isNotSameDigit);
            count += countGoodNumber(index+1, newRestricted, newNotEqual, num, rotationMap, cache); 
        }
        return cache[index][restricted][notEqual] = count;
    }

    int [] createArray(int n) {
        int noOfDigits = (int)Math.floor(Math.log10(n))+1;
        int arr[] = new int[noOfDigits];
        int j = arr.length-1;
        while(n>0) {
            int d=n%10;
            arr[j] = d;
            j--;
            n/=10;
        }
        return arr;
    }
    public int rotatedDigits(int n) {
        Integer cache[][][] = new Integer[10][2][2]; 
        HashMap<Integer, Integer> rotationMap = new HashMap<>();
        int numArr[] = createArray(n);
        int count = 0;
        getRotationMap(rotationMap);
        count = countGoodNumber(0, 1, 0, numArr, rotationMap, cache);

        return count;
    }
}

/*

 */