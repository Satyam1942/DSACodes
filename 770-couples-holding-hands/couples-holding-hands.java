class Solution {
    public int minSwapsCouples(int[] row) {
        int length = row.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < length; i += 2) {
            int u = row[i];
            int v = row[i + 1];
            map.put(u, v);
            map.put(v, u);
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

            int neighborOfFirstElementPartner = map.get(firstElementPartner);
            int indexOfNeighborOfFirstElementPartner = indexMap.get(firstElementPartner);
            int neighborOfSecondElementPartner = map.get(secondElementPartner);
            int indexOfNeighborOfSecondElementPartner = indexMap.get(secondElementPartner);

            if (neighborOfFirstElementPartner == secondElementPartner) {
                row[i + 1] = firstElementPartner;
                row[indexOfNeighborOfFirstElementPartner] = secondElement;
                indexMap.put(secondElement, indexOfNeighborOfFirstElementPartner);
                indexMap.put(firstElementPartner, i + 1);
                map.put(firstElement, firstElementPartner);
                map.put(firstElementPartner, firstElement);
                map.put(secondElement, neighborOfFirstElementPartner);
                map.put(neighborOfFirstElementPartner, secondElement);
            } else if (neighborOfSecondElementPartner == firstElementPartner) {
                row[i] = secondElementPartner;
                row[indexOfNeighborOfSecondElementPartner] = firstElement;
                indexMap.put(firstElement, indexOfNeighborOfSecondElementPartner);
                indexMap.put(secondElementPartner, i);
                map.put(firstElement, firstElementPartner);
                map.put(firstElementPartner, firstElement);
                map.put(secondElement, neighborOfFirstElementPartner);
                map.put(neighborOfFirstElementPartner, secondElement);
            } else {
                row[i + 1] = firstElementPartner;
                row[indexOfNeighborOfFirstElementPartner] = secondElement;
                indexMap.put(secondElement, indexOfNeighborOfFirstElementPartner);
                indexMap.put(firstElementPartner, i + 1);
                map.put(firstElement, firstElementPartner);
                map.put(firstElementPartner, firstElement);
                map.put(secondElement, neighborOfFirstElementPartner);
                map.put(neighborOfFirstElementPartner, secondElement);
            }
            swipes++;
        }
        return swipes;
    }
}