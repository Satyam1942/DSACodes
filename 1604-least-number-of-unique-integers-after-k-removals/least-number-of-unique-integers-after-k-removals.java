class Solution {
    void calculateFrequencyOfEachElement(int[] arr, HashMap<Integer, Integer> freq) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int curFreq = freq.getOrDefault(arr[i], 0);
            freq.put(arr[i], curFreq + 1);
        }
    }

    void initialiseBucket(int[] bucket, HashMap<Integer, Integer> freq) {
        for (Map.Entry<Integer, Integer> i : freq.entrySet()) {
            int index = i.getValue() - 1;
            bucket[index]++;
        }
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        calculateFrequencyOfEachElement(arr, freq);

        int length = arr.length;
        int[] bucket = new int[length];
        initialiseBucket(bucket, freq);

        int noOfUniqueElements = freq.size();

        for (int i = 0; i < length; i++) {
            int removingCost = i + 1;
            int totalCost = removingCost * bucket[i];

            if (k >= totalCost) {
                k -= totalCost;
                noOfUniqueElements -= bucket[i];
            } else {
                noOfUniqueElements -= k / removingCost;
                k = 0;
                break;
            }
        }

        return noOfUniqueElements;

    }
}