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

    int[] createArray(int n) {
        int noOfDigits = (int) Math.floor(Math.log10(n)) + 1;
        int arr[] = new int[noOfDigits];
        int j = arr.length - 1;
        while (n > 0) {
            int d = n % 10;
            arr[j] = d;
            j--;
            n /= 10;
        }
        return arr;
    }

    public int rotatedDigits(int n) {
        int length = (int) Math.floor(Math.log10(n)) + 1;
        Integer cache[][][] = new Integer[length+1][2][2];
        HashMap<Integer, Integer> rotationMap = new HashMap<>();
        
        int num[] = createArray(n);
        getRotationMap(rotationMap);

        for (int restricted = 0; restricted <= 1; restricted++) {
            cache[length][restricted][1] = 1;
            cache[length][restricted][0] = 0;
        }

        for (int index = length - 1; index >= 0; index--) {
            for (int restricted = 0; restricted <= 1; restricted++) {
                for (int notEqual = 0; notEqual <= 1; notEqual++) {
                    int limit = (restricted == 1) ? num[index] : 9;
                    int count = 0;
                    for (Map.Entry<Integer, Integer> i : rotationMap.entrySet()) {
                        if (i.getKey() > limit) {
                            continue;
                        }
                        int isNotSameDigit = (i.getValue() == i.getKey()) ? 0 : 1;
                        int isSame = (i.getKey() == num[index]) ? 1 : 0;
                        int newRestricted = Math.min(restricted, isSame);
                        int newNotEqual = Math.max(notEqual, isNotSameDigit);
                        count += cache[index + 1][newRestricted][newNotEqual];
                    }
                    cache[index][restricted][notEqual] = count;
                }
            }
        }

        return cache[0][1][0];
    }
}

/*

 */