class Solution {
    public int minSwapsCouples(int[] row) {
        int length = row.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < length; i += 2) {
            int u = row[i];
            int v = row[i + 1];
            indexMap.put(u, i);
            indexMap.put(v, i + 1);
        }

        int swipes = 0;
        for (int i = 0; i < length; i += 2) {
            int firstElement = row[i];
            int secondElement = row[i + 1];
            int firstElementPartner = (firstElement % 2 == 0) ? firstElement + 1 : firstElement - 1;
            int secondElementPartner = (secondElement % 2 == 0) ? secondElement + 1 : secondElement - 1;

            if (secondElement == firstElementPartner || firstElement == secondElementPartner) {
                continue;
            }

            int indexOfNeighborOfFirstElementPartner = indexMap.get(firstElementPartner);
            int neighborOfFirstElementPartner = row[indexOfNeighborOfFirstElementPartner];
            int indexOfNeighborOfSecondElementPartner = indexMap.get(secondElementPartner);
            int neighborOfSecondElementPartner = row[secondElementPartner];

            if (neighborOfSecondElementPartner == firstElementPartner) {
                // swipe first element of pair since its more optimal (creates 2 pair with one swipe)
                row[i] = secondElementPartner;
                row[indexOfNeighborOfSecondElementPartner] = firstElement;
                indexMap.put(firstElement, indexOfNeighborOfSecondElementPartner);
                indexMap.put(secondElementPartner, i);
            } else {
                // swipe second element of pair
                row[i + 1] = firstElementPartner;
                row[indexOfNeighborOfFirstElementPartner] = secondElement;
                indexMap.put(secondElement, indexOfNeighborOfFirstElementPartner);
                indexMap.put(firstElementPartner, i + 1);
            }
            swipes++;
        }
        return swipes;
    }
}