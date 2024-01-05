class Solution {
    public int totalFruit(int[] fruits) {

        int length = fruits.length;
        int i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int noOfFruits = 0;

        while (i <= j && j <= length) {
            if (map.size() > 2) {
                noOfFruits = Math.max(noOfFruits, j - i - 1);
                int freq = map.get(fruits[i]);
                if (freq == 1)
                    map.remove(fruits[i]);
                else
                    map.put(fruits[i], freq - 1);
                i++;
                continue;
            }
            if (j == length)
                noOfFruits = Math.max(noOfFruits, j - i);

            if (j < length)
                map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            j++;
        }

        return noOfFruits;

    }
}